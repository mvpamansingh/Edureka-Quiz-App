@file:OptIn(ExperimentalFoundationApi::class)

package com.example.edureka.presentation.quiz

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import com.example.edureka.R
import com.example.edureka.presentation.Utils.Constants
import com.example.edureka.presentation.Utils.Dimens
import com.example.edureka.presentation.common.ButtonBox
import com.example.edureka.presentation.common.QuizAppBar
import com.example.edureka.presentation.quiz.component.QuizInterface
import com.example.edureka.presentation.quiz.component.ShimmerEffectQuizInterface
import kotlinx.coroutines.launch


@Composable
fun QuizScreen(
    numOfQuiz:Int,
    quizCategory:String,
    quizDifficulty:String,
    quizType:String,
    event:(EventQuizScreen)->Unit,
    state:StateQuizScreen
)
{
    LaunchedEffect(key1 = Unit) {

        val difficulty= when(quizDifficulty)
        {
            "Hard"->"hard"
            "Medium"->"medium"
            else->"easy"
        }
        val type= when(quizType)
        {
            "Multiple Choice"->"multiple"
            else->"boolean"
        }
        event(EventQuizScreen.GetQuizzes(numOfQuiz, Constants.categoriesMap[quizCategory]!!, difficulty, type))
    }


    Column(

        modifier = Modifier.fillMaxSize()
    ) {

        QuizAppBar(quizCategory= quizCategory)
        {

        }

        Column(modifier= Modifier
            .padding(Dimens.VerySmallPadding)
            .fillMaxSize()) 
        {
        
            
            Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))
            
            Row(
                modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                
                Text(text = "Questions : $numOfQuiz", color = colorResource(id = R.color.blue_grey))
                Text(text = quizDifficulty, color = colorResource(id = R.color.blue_grey))

            }
            Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))


            Box(
                modifier= Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(Dimens.MediumCornerRadius))
                    .background(colorResource(id = R.color.orange)),

            )
            

            Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))

            // quiz interface
            
            if(quizFetched(state))
            {

                val pagerState= rememberPagerState()
                {
                    state.quizState.size
                }

                HorizontalPager(state= pagerState){index->
                    QuizInterface(modifier= Modifier.weight(1f),
                        onOptionSelected = {},
                        quizState = state.quizState[index],
                        qNumber = index+1)
                }


                val buttonText by remember{
                    derivedStateOf {
                        when(pagerState.currentPage)
                        {
                            0->{
                                listOf("","Next")
                            }
                            state.quizState.size-1->{
                                listOf("Previous","Submit")
                            }
                            else->{
                                listOf("Previous","Next")
                            }
                        }
                    }
                }
                Row(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = Dimens.MediumPadding)
                        .navigationBarsPadding()
                )
                {
                    val scope = rememberCoroutineScope()
                    if(buttonText[0].isNotEmpty())
                    {
                        ButtonBox(text = "Previous",
                            padding =Dimens.SmallPadding,
                            fraction= 0.43f,
                            fontSize= Dimens.SmallTextSize,
                            textColor = colorResource(id = R.color.black)) {

                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage -1)
                            }

                        }
                    }


                    ButtonBox(text = buttonText[1],
                        padding =Dimens.SmallPadding,
                        borderColor = colorResource(id = R.color.orange),
                        containerColor = colorResource(id =R.color.dark_slate_blue),
                        fraction= 1f, textColor = colorResource(id = R.color.white),
                        fontSize= Dimens.SmallTextSize) {



                        if(pagerState.currentPage==state.quizState.size-1){
                            //TODO
                        }
                        else
                        {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }

                    }


                } 
            }

        }

    }
}


@Composable
fun quizFetched(state: StateQuizScreen): Boolean {


    return when
    {
        state.isLoading ->{
            ShimmerEffectQuizInterface()
            false
        }
        state.quizState?.isNotEmpty()==true->{
            true
        }
        else->
        {
            Text(text = state.error.toString(), color= colorResource(id =R.color.white))
            false
        }
    }
}
