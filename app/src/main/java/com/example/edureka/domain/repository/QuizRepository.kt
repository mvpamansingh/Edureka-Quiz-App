package com.example.edureka.domain.repository

import com.example.edureka.domain.model.Quiz

interface QuizRepository {


    suspend fun getQuizzes(amount:Int, category:Int, difficulty:String, type:String):List<Quiz>
}