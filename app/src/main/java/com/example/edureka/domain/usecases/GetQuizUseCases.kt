package com.example.edureka.domain.usecases

import com.example.edureka.common.Resource
import com.example.edureka.domain.model.Quiz
import com.example.edureka.domain.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class GetQuizUseCases(
    val quizRepository: QuizRepository
) {

   operator fun invoke (
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): Flow<Resource<List<Quiz>>> = flow {

        emit(Resource.Loading())


        try {
            emit(
                Resource.Success(
                    data = quizRepository.getQuizzes(
                        amount,
                        category,
                        difficulty,
                        type
                    )
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}

