package com.example.edureka.domain.di

import com.example.edureka.domain.repository.QuizRepository
import com.example.edureka.domain.usecases.GetQuizUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {




    @Provides
    @Singleton
    fun provideGetQuizzesUseCases(quizRepository:QuizRepository):GetQuizUseCases{
        return GetQuizUseCases(quizRepository)
    }
}