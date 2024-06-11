package com.example.edureka.presentation.quiz

import com.example.edureka.domain.model.Quiz

data class StateQuizScreen(


    val isLoading:Boolean = false,
    val quizState :List<QuizState> = listOf(),
    val error:String= ""
)





data class QuizState(
    val quiz:Quiz ?= null,
    val shuffledOptions:List<String> = emptyList(),
    val selectedOption: Int? = -1
)