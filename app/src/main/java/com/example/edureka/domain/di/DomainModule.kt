package com.example.edureka.domain.di

import com.example.edureka.domain.repository.QuizRepository
import com.example.edureka.domain.usecases.GetQuizUseCases
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {






    fun provideGetQuizzesUseCases(quizRepository:QuizRepository):GetQuizUseCases{
        return GetQuizUseCases(quizRepository)
    }
}