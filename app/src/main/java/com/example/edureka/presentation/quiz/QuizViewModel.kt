package com.example.edureka.presentation.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edureka.common.Resource
import com.example.edureka.domain.model.Quiz
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


                        val listOfQuizState:List<QuizState> = getListOfQuizState(resource.data)
                        _quizList.value = StateQuizScreen(quizState = listOfQuizState)
                    }
                }
            }
        }


    }

    private fun getListOfQuizState(data: List<Quiz>?): List<QuizState> {

        val listOfQuizState = mutableListOf<QuizState>()


        for(quiz in data!!)
        {
            val shuffledOptions = mutableListOf<String>().apply{
                add(quiz.correct_answer)
                addAll(quiz.incorrect_answers)

                shuffle()
            }

            listOfQuizState.add(QuizState(quiz,shuffledOptions, -1))
        }

        return listOfQuizState
    }


}