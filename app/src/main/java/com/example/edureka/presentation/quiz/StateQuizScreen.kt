package com.example.edureka.presentation.quiz

import com.example.edureka.domain.model.Quiz

data class StateQuizScreen(


    val isLoading:Boolean = false,
    val data :List<Quiz> ?= listOf(),
    val error:String= ""
)
