package com.example.edureka.presentation.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import com.example.edureka.R
import com.example.edureka.presentation.Utils.Constants
import com.example.edureka.presentation.Utils.Dimens
import com.example.edureka.presentation.common.QuizAppBar


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


        }

    }
}