package com.example.edureka.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.edureka.presentation.Utils.Constants
import com.example.edureka.presentation.Utils.Constants.difficulty
import com.example.edureka.presentation.Utils.Dimens
import com.example.edureka.presentation.Utils.Dimens.MediumSpacerHeight
import com.example.edureka.presentation.Utils.Dimens.SmallSpacerHeight
import com.example.edureka.presentation.common.AppDropDownMenu
import com.example.edureka.presentation.common.ButtonBox
import com.example.edureka.presentation.home.components.HomeHeader


@Composable
fun HomeScreen(
    state :StateHomeScreen,
    event:(EventHomeScreen)->Unit
) {

    Column(
        modifier= Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        HomeHeader()

        Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))
       AppDropDownMenu(menuName="Number of Questions: ", menuList= Constants.numberAsString, text= state.numberOfQuiz.toString() ,onDropDownClick = {event(EventHomeScreen.SetNumberOfQuizzes(it.toInt()))})

        Spacer(modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Category: ", menuList= Constants.categories, text= state.category,onDropDownClick = {event(EventHomeScreen.SetQuizCategory(it))})

        Spacer(modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Difficulty: ", menuList= difficulty,text= state.difficulty, onDropDownClick = {event(EventHomeScreen.SetQuizDifficulty(it))})

        Spacer(modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Types: ", menuList= Constants.type, text= state.type,onDropDownClick ={event(EventHomeScreen.SetQuizType(it))})

        Spacer(modifier= Modifier.height(MediumSpacerHeight))

        ButtonBox(text = "Generate Quiz", padding = Dimens.MediumPadding)
        {
            Log.d("answer", "${state.numberOfQuiz}  ${state.category}  ${state.difficulty}  ${state.type}")
        }
    }
}