package com.example.edureka.data.remote

import com.example.edureka.data.remote.dto.QuizResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi {


    @GET("api.php")
    suspend fun getQuizzes(
        @Query("amount") amount:Int,
        @Query("category") category:Int,
        @Query("difficulty") difficulty:String,
        @Query("type") type:String
    ):QuizResponse

}