package com.example.edureka.data.remote.dto

import com.example.edureka.domain.model.Quiz

data class QuizResponse(
    val response_code: Int,
    val results: List<Quiz>
)