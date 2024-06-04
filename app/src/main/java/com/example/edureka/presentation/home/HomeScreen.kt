package com.example.edureka.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.edureka.presentation.Utils.Constants
import com.example.edureka.presentation.Utils.Constants.difficulty
import com.example.edureka.presentation.Utils.Dimens
import com.example.edureka.presentation.Utils.Dimens.MediumSpacerHeight
import com.example.edureka.presentation.Utils.Dimens.SmallSpacerHeight
import com.example.edureka.presentation.common.AppDropDownMenu
import com.example.edureka.presentation.common.ButtonBox
import com.example.edureka.presentation.home.components.HomeHeader

@Preview
@Composable
fun HomeScreen() {

    Column(
        modifier= Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        HomeHeader()

        Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))
       AppDropDownMenu(menuName="Number of Questions: ", menuList= Constants.numberAsString, onDropDownClick = {})

        Spacer(modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Category: ", menuList= Constants.categories, onDropDownClick = {})

        Spacer(modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Difficulty: ", menuList= difficulty, onDropDownClick = {})

        Spacer(modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Types: ", menuList= Constants.type, onDropDownClick ={})

        Spacer(modifier= Modifier.height(MediumSpacerHeight))

        ButtonBox(text = "Generate Quiz", padding = Dimens.MediumPadding)
    }
}