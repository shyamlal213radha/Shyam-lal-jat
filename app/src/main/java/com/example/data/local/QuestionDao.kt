package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {

    @Query("SELECT COUNT(*) FROM cached_questions")
    suspend fun getQuestionCount(): Int

    @Query("SELECT COUNT(*) FROM cached_questions")
    fun getQuestionCountFlow(): Flow<Int>

    @Query("SELECT * FROM cached_questions ORDER BY id ASC")
    suspend fun getAllQuestions(): List<QuestionEntity>

    @Query("SELECT * FROM cached_questions WHERE categoryName = :categoryName ORDER BY id ASC")
    suspend fun getQuestionsByCategory(categoryName: String): List<QuestionEntity>

    @Query("SELECT * FROM cached_questions WHERE topicName = :topicName ORDER BY id ASC")
    suspend fun getQuestionsByTopic(topicName: String): List<QuestionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(questions: List<QuestionEntity>)

    @Query("DELETE FROM cached_questions")
    suspend fun clearAll()
}
