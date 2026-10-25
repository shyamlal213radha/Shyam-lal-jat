package com.example.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.data.datasource.ArtCultureQuestions
import com.example.data.datasource.ComprehensiveQuestionBank
import com.example.data.datasource.HistoryQuestions
import com.example.data.local.AppDatabase
import com.example.data.local.QuestionDao
import com.example.data.local.QuestionEntity
import com.example.data.model.Category
import com.example.data.model.Question
import com.example.data.model.QuizConfig
import com.example.data.model.Topic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class QuizRepository(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("rajasthan_quiz_prefs", Context.MODE_PRIVATE)

    private val database = AppDatabase.getInstance(context)
    val questionDao: QuestionDao = database.questionDao()

    val cachedCountFlow: Flow<Int> = questionDao.getQuestionCountFlow()

    // Master list of all questions combined (including comprehensive bank)
    val allQuestions: List<Question> by lazy {
        HistoryQuestions.list + ArtCultureQuestions.list + ComprehensiveQuestionBank.generatedList
    }

    /**
     * Seeds Room SQLite database with all 5,000+ questions so that
     * user can play the quiz completely offline without an active internet connection.
     */
    suspend fun populateCacheIfEmpty() = withContext(Dispatchers.IO) {
        val currentCount = questionDao.getQuestionCount()
        if (currentCount < allQuestions.size) {
            val entities = allQuestions.map { QuestionEntity.fromQuestion(it) }
            // Insert in batches of 500 for optimal Room SQLite transaction throughput
            entities.chunked(500).forEach { batch ->
                questionDao.insertAll(batch)
            }
        }
    }

    suspend fun getCachedCount(): Int = withContext(Dispatchers.IO) {
        questionDao.getQuestionCount()
    }

    /**
     * Get seen question IDs to prevent repeating questions across multiple quizzes.
     */
    fun getSeenQuestionIds(): Set<Int> {
        val raw = prefs.getStringSet("seen_question_ids", emptySet()) ?: emptySet()
        return raw.mapNotNull { it.toIntOrNull() }.toSet()
    }

    fun markQuestionsAsSeen(ids: List<Int>) {
        val current = getSeenQuestionIds().toMutableSet()
        current.addAll(ids)
        prefs.edit().putStringSet("seen_question_ids", current.map { it.toString() }.toSet()).apply()
    }

    fun resetSeenQuestions() {
        prefs.edit().remove("seen_question_ids").apply()
    }

    /**
     * Get bookmarked question IDs for personal revision
     */
    fun getBookmarkedIds(): Set<Int> {
        val raw = prefs.getStringSet("bookmarked_ids", emptySet()) ?: emptySet()
        return raw.mapNotNull { it.toIntOrNull() }.toSet()
    }

    fun toggleBookmark(questionId: Int) {
        val current = getBookmarkedIds().toMutableSet()
        if (current.contains(questionId)) {
            current.remove(questionId)
        } else {
            current.add(questionId)
        }
        prefs.edit().putStringSet("bookmarked_ids", current.map { it.toString() }.toSet()).apply()
    }

    /**
     * Build a list of questions guaranteed not to repeat during the quiz session.
     * If avoidSeenQuestions is true, it prioritizes questions the user hasn't seen yet.
     */
    fun generateQuizQuestions(config: QuizConfig): List<Question> {
        var pool = when (config.category) {
            Category.ALL -> allQuestions
            Category.HISTORY -> allQuestions.filter { it.category == Category.HISTORY }
            Category.ART_CULTURE -> allQuestions.filter { it.category == Category.ART_CULTURE }
        }

        if (config.selectedTopic != null) {
            pool = pool.filter { it.topic == config.selectedTopic }
        }

        if (pool.isEmpty()) {
            pool = allQuestions
        }

        // Shuffled pool guaranteeing no duplicates in the session
        val distinctPool = pool.distinctBy { it.id }.shuffled()

        val selectedQuestions = if (config.avoidSeenQuestions) {
            val seenIds = getSeenQuestionIds()
            val unseen = distinctPool.filter { it.id !in seenIds }

            if (unseen.isNotEmpty()) {
                if (unseen.size >= config.questionCount) {
                    unseen.take(config.questionCount)
                } else {
                    // Include all remaining unseen, then supplement from seen if needed
                    val needed = config.questionCount - unseen.size
                    val supplement = distinctPool.filter { it.id in seenIds }.shuffled().take(needed)
                    unseen + supplement
                }
            } else {
                // User has seen all questions in this filter, take distinct shuffled
                distinctPool.take(config.questionCount)
            }
        } else {
            distinctPool.take(config.questionCount)
        }

        return selectedQuestions
    }

    /**
     * Retrieves questions directly from the local Room SQLite cache.
     * Guarantees 100% offline gameplay without needing any internet connection.
     */
    suspend fun getQuestionsFromRoom(config: QuizConfig): List<Question> = withContext(Dispatchers.IO) {
        val cachedCount = questionDao.getQuestionCount()
        if (cachedCount == 0) {
            // If Room has not finished seeding yet, generate from bundled lists
            return@withContext generateQuizQuestions(config)
        }

        val entities = when (config.category) {
            Category.ALL -> questionDao.getAllQuestions()
            Category.HISTORY -> questionDao.getQuestionsByCategory(Category.HISTORY.name)
            Category.ART_CULTURE -> questionDao.getQuestionsByCategory(Category.ART_CULTURE.name)
        }

        var pool = entities.map { it.toQuestion() }
        if (config.selectedTopic != null) {
            pool = pool.filter { it.topic == config.selectedTopic }
        }

        if (pool.isEmpty()) {
            pool = entities.map { it.toQuestion() }
        }

        val distinctPool = pool.distinctBy { it.id }.shuffled()

        val selected = if (config.avoidSeenQuestions) {
            val seenIds = getSeenQuestionIds()
            val unseen = distinctPool.filter { it.id !in seenIds }

            if (unseen.isNotEmpty()) {
                if (unseen.size >= config.questionCount) {
                    unseen.take(config.questionCount)
                } else {
                    val needed = config.questionCount - unseen.size
                    val supplement = distinctPool.filter { it.id in seenIds }.shuffled().take(needed)
                    unseen + supplement
                }
            } else {
                distinctPool.take(config.questionCount)
            }
        } else {
            distinctPool.take(config.questionCount)
        }

        selected
    }

    /**
     * Build a focused retry session from questions answered incorrectly, ensuring no duplicates.
     */
    fun generateRetrySession(incorrectQuestions: List<Question>): List<Question> {
        return incorrectQuestions.distinctBy { it.id }.shuffled()
    }

    fun getTotalQuestionsCount(): Int = allQuestions.size
    fun getHistoryQuestionsCount(): Int = allQuestions.count { it.category == Category.HISTORY }
    fun getArtCultureQuestionsCount(): Int = allQuestions.count { it.category == Category.ART_CULTURE }
}
