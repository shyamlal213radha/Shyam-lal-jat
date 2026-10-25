package com.example.data.model

enum class Category(val displayName: String, val subtitle: String) {
    ALL("सम्पूर्ण राजस्थान GK", "इतिहास + कला एवं संस्कृति के सभी प्रश्न"),
    HISTORY("राजस्थान का इतिहास", "सभ्यताएं, युद्ध, राजवंश, 1857, प्रजामंडल व एकीकरण"),
    ART_CULTURE("कला एवं संस्कृति", "लोक देवता, मेले, त्यौहार, दुर्ग, आभूषण, नृत्य व चित्रकला")
}

enum class Topic(val displayName: String, val category: Category) {
    // History
    ARCHAEOLOGY_INSCRIPTIONS("सभ्यता स्थल, उत्खनन व शिलालेख", Category.HISTORY),
    DYNASTIES_RULERS("प्रमुख राजवंश, शासक, उपाधियां व सेनापति", Category.HISTORY),
    BATTLES_JOHAR("राजस्थान के प्रमुख युद्ध, साके व जौहर", Category.HISTORY),
    REVOLT_1857("1857 की क्रांति, छावनियां व क्रांतिकारी", Category.HISTORY),
    PEASANT_PRAJAMANDAL("किसान आंदोलन व प्रजामंडल सारांश", Category.HISTORY),
    INTEGRATION_PERSONALITIES("राजस्थान का एकीकरण, समाचार पत्र व प्रथम व्यक्तित्व", Category.HISTORY),

    // Art & Culture
    LOK_DEVTA_DEVI("लोक देवता, वाहन व कुल देवियां", Category.ART_CULTURE),
    SANTS_SECTS("संत, संप्रदाय व मांड गायिकाएं", Category.ART_CULTURE),
    DANCE_MUSIC_INSTRUMENTS("लोकनृत्य, संगीत घराने व वाद्य यंत्र", Category.ART_CULTURE),
    CUSTOMS_ORNAMENTS("रीति-रिवाज, रस्में, प्रथाएं व आभूषण", Category.ART_CULTURE),
    FAIRS_FESTIVALS("प्रसिद्ध मेले, त्यौहार व उत्सव", Category.ART_CULTURE),
    FORTS_HAVELIS_CHHATRIS("प्रमुख दुर्ग, तोपें, महल, हवेलियां व छतरियां", Category.ART_CULTURE),
    PAINTINGS_HANDICRAFTS("चित्रकला शैलियां, चित्रकार व हस्तकलाएं", Category.ART_CULTURE)
}

enum class QuizMode(val displayName: String, val desc: String) {
    EXAM("परीक्षा मोड (Exam Mode)", "सभी प्रश्नों के उत्तर देने के बाद अंत में स्कोर और व्याख्या देखें"),
    PRACTICE("अभ्यास मोड (Practice Mode)", "उत्तर चुनते ही तुरंत सही/गलत का पता और व्याख्या दिखेगी")
}

data class Question(
    val id: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String,
    val category: Category,
    val topic: Topic
)

data class QuestionReviewItem(
    val question: Question,
    val userSelectedIndex: Int?, // null if skipped
    val isCorrect: Boolean,
    val isSkipped: Boolean
)

data class QuizResultSummary(
    val totalQuestions: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val skippedCount: Int,
    val scorePercentage: Float,
    val timeTakenSeconds: Long,
    val feedbackTitle: String,
    val feedbackSubtitle: String,
    val reviews: List<QuestionReviewItem>
)

data class QuizConfig(
    val category: Category = Category.ALL,
    val selectedTopic: Topic? = null,
    val questionCount: Int = 20, // 10, 20, 50, or Int.MAX_VALUE for All
    val mode: QuizMode = QuizMode.PRACTICE,
    val avoidSeenQuestions: Boolean = true, // Guarantee no repeats across sessions
    val timerSecondsPerQuestion: Int = 30 // 15, 30, 45, 60, or 0 (Off)
)

data class QuizSessionState(
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val userAnswers: Map<Int, Int> = emptyMap(), // questionId -> selectedOptionIndex
    val bookmarkedIds: Set<Int> = emptySet(),
    val isSubmitted: Boolean = false,
    val startTimeMs: Long = 0L,
    val endTimeMs: Long = 0L,
    val mode: QuizMode = QuizMode.PRACTICE,
    val timerSecondsPerQuestion: Int = 30,
    val remainingSeconds: Int = 30,
    val isTimerActive: Boolean = false,
    val timedOutQuestionIds: Set<Int> = emptySet(),
    val resultSummary: QuizResultSummary? = null
)
