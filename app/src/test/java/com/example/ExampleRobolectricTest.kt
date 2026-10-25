package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.datasource.ArtCultureQuestions
import com.example.data.datasource.HistoryQuestions
import com.example.data.model.Category
import com.example.data.model.QuizConfig
import com.example.data.repository.QuizRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun `read string from context matches app name`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Rajasthan GK Quiz", appName)
    }

    @Test
    fun `questions bank has between 5000 and 8000 questions and zero duplicate ids`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val repository = QuizRepository(context)
        val allQuestions = repository.allQuestions
        
        assertTrue("Bank should have at least 5000 questions, got ${allQuestions.size}", allQuestions.size >= 5000)
        assertTrue("Bank should have at most 8000 questions, got ${allQuestions.size}", allQuestions.size <= 8000)

        val ids = allQuestions.map { it.id }
        val uniqueIds = ids.toSet()
        assertEquals("All questions must have distinct IDs", ids.size, uniqueIds.size)
    }

    @Test
    fun `generated quiz session has no repeated questions`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val repository = QuizRepository(context)
        val config = QuizConfig(category = Category.ALL, questionCount = 50)
        val questions = repository.generateQuizQuestions(config)

        assertTrue("Should return questions", questions.isNotEmpty())
        assertEquals("Should not have duplicate questions in a session", questions.size, questions.distinctBy { it.id }.size)
    }

    @Test
    fun `room database offline cache persists and retrieves questions`() = kotlinx.coroutines.test.runTest {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val repository = QuizRepository(context)
        repository.populateCacheIfEmpty()
        val count = repository.getCachedCount()
        assertTrue("Room cache should store 5000+ questions, got $count", count >= 5000)

        val config = QuizConfig(category = Category.HISTORY, questionCount = 25)
        val offlineQuestions = repository.getQuestionsFromRoom(config)
        assertEquals(25, offlineQuestions.size)
        assertTrue(offlineQuestions.all { it.category == Category.HISTORY })
    }
}
