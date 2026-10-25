package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Category
import com.example.data.model.Question
import com.example.data.model.QuestionReviewItem
import com.example.data.model.QuizConfig
import com.example.data.model.QuizMode
import com.example.data.model.QuizResultSummary
import com.example.data.model.QuizSessionState
import com.example.data.model.Topic
import com.example.data.repository.QuizRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class Screen {
    HOME,
    QUIZ,
    RESULT,
    BOOKMARKS
}

data class QuizUiState(
    val currentScreen: Screen = Screen.HOME,
    val config: QuizConfig = QuizConfig(),
    val session: QuizSessionState = QuizSessionState(),
    val totalQuestionsInBank: Int = 0,
    val historyCount: Int = 0,
    val artCultureCount: Int = 0,
    val seenCount: Int = 0,
    val bookmarkedCount: Int = 0,
    val bookmarkedQuestions: List<Question> = emptyList(),
    val cachedInRoomCount: Int = 0,
    val isRoomCacheReady: Boolean = false
)

class QuizViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuizRepository(application.applicationContext)

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    private var timerJob: Job? = null

    init {
        refreshBankStats()
        // Initialize Room local database offline cache asynchronously
        viewModelScope.launch {
            repository.populateCacheIfEmpty()
            val cached = repository.getCachedCount()
            _uiState.update { it.copy(cachedInRoomCount = cached, isRoomCacheReady = cached > 0) }
        }
        viewModelScope.launch {
            repository.cachedCountFlow.collect { count ->
                _uiState.update { it.copy(cachedInRoomCount = count, isRoomCacheReady = count > 0) }
            }
        }
    }

    fun refreshBankStats() {
        val seen = repository.getSeenQuestionIds().size
        val bookmarks = repository.getBookmarkedIds()
        val all = repository.allQuestions
        _uiState.update { current ->
            current.copy(
                totalQuestionsInBank = repository.getTotalQuestionsCount(),
                historyCount = repository.getHistoryQuestionsCount(),
                artCultureCount = repository.getArtCultureQuestionsCount(),
                seenCount = seen,
                bookmarkedCount = bookmarks.size,
                bookmarkedQuestions = all.filter { it.id in bookmarks }
            )
        }
    }

    fun setCategory(category: Category) {
        _uiState.update { it.copy(config = it.config.copy(category = category, selectedTopic = null)) }
    }

    fun setTopic(topic: Topic?) {
        _uiState.update { it.copy(config = it.config.copy(selectedTopic = topic)) }
    }

    fun setQuestionCount(count: Int) {
        _uiState.update { it.copy(config = it.config.copy(questionCount = count)) }
    }

    fun setQuizMode(mode: QuizMode) {
        _uiState.update { it.copy(config = it.config.copy(mode = mode)) }
    }

    fun setAvoidSeen(avoid: Boolean) {
        _uiState.update { it.copy(config = it.config.copy(avoidSeenQuestions = avoid)) }
    }

    fun setTimerSecondsPerQuestion(seconds: Int) {
        _uiState.update { it.copy(config = it.config.copy(timerSecondsPerQuestion = seconds)) }
    }

    fun startQuiz() {
        viewModelScope.launch {
            val config = _uiState.value.config
            val questions = repository.getQuestionsFromRoom(config)
            if (questions.isEmpty()) return@launch

            val bookmarked = repository.getBookmarkedIds()

            _uiState.update {
                it.copy(
                    currentScreen = Screen.QUIZ,
                    session = QuizSessionState(
                        questions = questions,
                        currentIndex = 0,
                        userAnswers = emptyMap(),
                        bookmarkedIds = bookmarked,
                        isSubmitted = false,
                        startTimeMs = System.currentTimeMillis(),
                        mode = config.mode,
                        timerSecondsPerQuestion = config.timerSecondsPerQuestion,
                        remainingSeconds = config.timerSecondsPerQuestion,
                        isTimerActive = config.timerSecondsPerQuestion > 0,
                        timedOutQuestionIds = emptySet()
                    )
                )
            }
            startQuestionTimer()
        }
    }

    fun selectOption(questionId: Int, optionIndex: Int) {
        stopTimer()
        _uiState.update { current ->
            val updatedAnswers = current.session.userAnswers.toMutableMap()
            updatedAnswers[questionId] = optionIndex
            current.copy(session = current.session.copy(userAnswers = updatedAnswers))
        }
    }

    fun nextQuestion() {
        _uiState.update { current ->
            val nextIndex = (current.session.currentIndex + 1).coerceAtMost(current.session.questions.size - 1)
            current.copy(session = current.session.copy(currentIndex = nextIndex))
        }
        startQuestionTimer()
    }

    fun previousQuestion() {
        _uiState.update { current ->
            val prevIndex = (current.session.currentIndex - 1).coerceAtLeast(0)
            current.copy(session = current.session.copy(currentIndex = prevIndex))
        }
        startQuestionTimer()
    }

    fun jumpToQuestion(index: Int) {
        _uiState.update { current ->
            val target = index.coerceIn(0, current.session.questions.size - 1)
            current.copy(session = current.session.copy(currentIndex = target))
        }
        startQuestionTimer()
    }

    fun toggleBookmark(questionId: Int) {
        repository.toggleBookmark(questionId)
        val updatedBookmarks = repository.getBookmarkedIds()
        _uiState.update { current ->
            current.copy(
                session = current.session.copy(bookmarkedIds = updatedBookmarks),
                bookmarkedCount = updatedBookmarks.size,
                bookmarkedQuestions = repository.allQuestions.filter { it.id in updatedBookmarks }
            )
        }
    }

    private fun startQuestionTimer() {
        timerJob?.cancel()
        val session = _uiState.value.session
        val duration = session.timerSecondsPerQuestion

        if (duration <= 0 || session.isSubmitted || session.questions.isEmpty()) {
            _uiState.update { it.copy(session = it.session.copy(isTimerActive = false)) }
            return
        }

        val currentQ = session.questions.getOrNull(session.currentIndex) ?: return
        // If question already answered or already timed out, do not run timer
        if (session.userAnswers.containsKey(currentQ.id) || session.timedOutQuestionIds.contains(currentQ.id)) {
            _uiState.update { it.copy(session = it.session.copy(isTimerActive = false, remainingSeconds = 0)) }
            return
        }

        _uiState.update {
            it.copy(
                session = it.session.copy(
                    remainingSeconds = duration,
                    isTimerActive = true
                )
            )
        }

        timerJob = viewModelScope.launch {
            var timeLeft = duration
            while (timeLeft > 0) {
                delay(1000L)
                timeLeft -= 1
                _uiState.update { it.copy(session = it.session.copy(remainingSeconds = timeLeft)) }
            }
            handleQuestionTimeout()
        }
    }

    private fun handleQuestionTimeout() {
        val session = _uiState.value.session
        if (session.questions.isEmpty() || session.isSubmitted) return
        val currentQ = session.questions[session.currentIndex]

        val updatedTimedOut = session.timedOutQuestionIds + currentQ.id
        _uiState.update {
            it.copy(
                session = it.session.copy(
                    isTimerActive = false,
                    remainingSeconds = 0,
                    timedOutQuestionIds = updatedTimedOut
                )
            )
        }

        if (session.mode == QuizMode.EXAM) {
            // Auto advance in exam mode after timeout
            viewModelScope.launch {
                delay(700L)
                if (_uiState.value.session.currentIndex < session.questions.size - 1) {
                    nextQuestion()
                } else {
                    submitQuiz()
                }
            }
        }
    }

    private fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
        _uiState.update { it.copy(session = it.session.copy(isTimerActive = false)) }
    }

    fun submitQuiz() {
        stopTimer()
        val session = _uiState.value.session
        val endTime = System.currentTimeMillis()
        val timeSeconds = ((endTime - session.startTimeMs) / 1000).coerceAtLeast(1)

        val reviews = session.questions.map { question ->
            val userAns = session.userAnswers[question.id]
            val isCorrect = userAns != null && userAns == question.correctAnswerIndex
            val isSkipped = userAns == null
            QuestionReviewItem(
                question = question,
                userSelectedIndex = userAns,
                isCorrect = isCorrect,
                isSkipped = isSkipped
            )
        }

        val total = session.questions.size
        val correct = reviews.count { it.isCorrect }
        val wrong = reviews.count { !it.isCorrect && !it.isSkipped }
        val skipped = reviews.count { it.isSkipped }
        val percentage = if (total > 0) (correct.toFloat() / total) * 100f else 0f

        val (title, subtitle) = when {
            percentage >= 90f -> "उत्कृष्ट प्रदर्शन! 🌟" to "आपकी राजस्थान GK पर जबर्दस्त पकड़ है। आपने समय सीमा के भीतर लगभग सभी प्रश्नों के सही उत्तर दिए!"
            percentage >= 75f -> "बहुत बढ़िया! 🎯" to "शानदार स्कोर! राजस्थान इतिहास व संस्कृति की आपकी गति और तैयारी काफी अच्छी है।"
            percentage >= 50f -> "अच्छा प्रयास! 👍" to "सराहनीय स्कोर! समय प्रबंधन और कुछ कठिन विषयों का रिवीजन कर आप और बेहतर कर सकते हैं।"
            else -> "निरंतर अभ्यास करें! 📚" to "व्याख्याओं को ध्यान से पढ़ें और गलत प्रश्नों को पुनः हल करें। अभ्यास से पूर्णता आएगी!"
        }

        val summary = QuizResultSummary(
            totalQuestions = total,
            correctCount = correct,
            wrongCount = wrong,
            skippedCount = skipped,
            scorePercentage = percentage,
            timeTakenSeconds = timeSeconds,
            feedbackTitle = title,
            feedbackSubtitle = subtitle,
            reviews = reviews
        )

        // Mark all answered and completed questions as seen
        repository.markQuestionsAsSeen(session.questions.map { it.id })

        _uiState.update {
            it.copy(
                currentScreen = Screen.RESULT,
                session = it.session.copy(
                    isSubmitted = true,
                    endTimeMs = endTime,
                    resultSummary = summary
                ),
                seenCount = repository.getSeenQuestionIds().size
            )
        }
    }

    /**
     * Retake ONLY the questions answered incorrectly, ensuring zero repetition of correctly answered ones.
     */
    fun retakeIncorrectOnly() {
        val summary = _uiState.value.session.resultSummary ?: return
        val incorrectQuestions = summary.reviews.filter { !it.isCorrect }.map { it.question }
        if (incorrectQuestions.isEmpty()) return

        val bookmarked = repository.getBookmarkedIds()
        val timerSec = _uiState.value.config.timerSecondsPerQuestion

        _uiState.update {
            it.copy(
                currentScreen = Screen.QUIZ,
                session = QuizSessionState(
                    questions = repository.generateRetrySession(incorrectQuestions),
                    currentIndex = 0,
                    userAnswers = emptyMap(),
                    bookmarkedIds = bookmarked,
                    isSubmitted = false,
                    startTimeMs = System.currentTimeMillis(),
                    mode = it.config.mode,
                    timerSecondsPerQuestion = timerSec,
                    remainingSeconds = timerSec,
                    isTimerActive = timerSec > 0,
                    timedOutQuestionIds = emptySet()
                )
            )
        }
        startQuestionTimer()
    }

    fun retakeCurrentQuiz() {
        val currentQuestions = _uiState.value.session.questions
        val bookmarked = repository.getBookmarkedIds()
        val timerSec = _uiState.value.config.timerSecondsPerQuestion

        _uiState.update {
            it.copy(
                currentScreen = Screen.QUIZ,
                session = QuizSessionState(
                    questions = currentQuestions.shuffled(),
                    currentIndex = 0,
                    userAnswers = emptyMap(),
                    bookmarkedIds = bookmarked,
                    isSubmitted = false,
                    startTimeMs = System.currentTimeMillis(),
                    mode = it.config.mode,
                    timerSecondsPerQuestion = timerSec,
                    remainingSeconds = timerSec,
                    isTimerActive = timerSec > 0,
                    timedOutQuestionIds = emptySet()
                )
            )
        }
        startQuestionTimer()
    }

    fun resetSeenHistory() {
        repository.resetSeenQuestions()
        refreshBankStats()
    }

    fun navigateToHome() {
        stopTimer()
        refreshBankStats()
        _uiState.update { it.copy(currentScreen = Screen.HOME) }
    }

    fun navigateToBookmarks() {
        stopTimer()
        refreshBankStats()
        _uiState.update { it.copy(currentScreen = Screen.BOOKMARKS) }
    }

    override fun onCleared() {
        super.onCleared()
        stopTimer()
    }
}
