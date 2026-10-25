package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.Category
import com.example.data.model.Question
import com.example.data.model.Topic

/**
 * Room database entity for caching questions locally on device.
 * Ensures the quiz works 100% offline without any active internet connection.
 */
@Entity(tableName = "cached_questions")
data class QuestionEntity(
    @PrimaryKey
    val id: Int,
    val questionText: String,
    val option0: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val correctAnswerIndex: Int,
    val explanation: String,
    val categoryName: String,
    val topicName: String
) {
    fun toQuestion(): Question {
        val cat = try {
            Category.valueOf(categoryName)
        } catch (_: Exception) {
            Category.ALL
        }
        val top = try {
            Topic.valueOf(topicName)
        } catch (_: Exception) {
            Topic.ARCHAEOLOGY_INSCRIPTIONS
        }
        return Question(
            id = id,
            questionText = questionText,
            options = listOf(option0, option1, option2, option3),
            correctAnswerIndex = correctAnswerIndex,
            explanation = explanation,
            category = cat,
            topic = top
        )
    }

    companion object {
        fun fromQuestion(q: Question): QuestionEntity {
            return QuestionEntity(
                id = q.id,
                questionText = q.questionText,
                option0 = q.options.getOrElse(0) { "" },
                option1 = q.options.getOrElse(1) { "" },
                option2 = q.options.getOrElse(2) { "" },
                option3 = q.options.getOrElse(3) { "" },
                correctAnswerIndex = q.correctAnswerIndex,
                explanation = q.explanation,
                categoryName = q.category.name,
                topicName = q.topic.name
            )
        }
    }
}
