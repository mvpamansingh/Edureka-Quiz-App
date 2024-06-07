package com.example.edureka.presentation.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edureka.common.Resource
import com.example.edureka.domain.usecases.GetQuizUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getQuizUseCases: GetQuizUseCases
): ViewModel() {





    private val _quizList= MutableStateFlow(StateQuizScreen())
    val quizList= _quizList

    fun onEvent(event:EventQuizScreen){
        when(event)
        {
            is EventQuizScreen.GetQuizzes -> {
                getQuizzes( amount = event.numOfQuizzes, category = event.category, difficulty = event.difficulty, type = event.type)
            }
        }
    }


    private fun getQuizzes(amount:Int, category:Int, difficulty:String, type: String)
    {


        viewModelScope.launch {
            getQuizUseCases(amount, category, difficulty, type).collect{resource->

                when(resource)
                {
                    is Resource.Error -> {

                        _quizList.value= StateQuizScreen(error = resource.message.toString())
                    }

                    is Resource.Loading ->{
                        _quizList.value= StateQuizScreen(isLoading =true)
                    }

                    is Resource.Success ->{
                        for(quiz in resource.data!!)
                        {
                            Log.d("quiz", quiz.toString())

                        }

                        _quizList.value = StateQuizScreen(data= resource.data)
                    }
                }
            }
        }


    }


}