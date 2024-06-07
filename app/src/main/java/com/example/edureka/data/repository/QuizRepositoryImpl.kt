package com.example.edureka.data.repository

import com.example.edureka.data.remote.QuizApi
import com.example.edureka.domain.model.Quiz
import com.example.edureka.domain.repository.QuizRepository


class QuizRepositoryImpl(
   private val quizApi: QuizApi
) :QuizRepository {
    override suspend fun getQuizzes(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Quiz> {

        return quizApi.getQuizzes(amount, category, difficulty, type).results
    }
}