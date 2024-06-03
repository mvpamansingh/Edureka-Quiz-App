package com.example.edureka.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.example.edureka.R
import com.example.edureka.presentation.Utils.Dimens

@Composable
fun ButtonBox(
    text:String,
    padding: Dp
)
{
    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .height(Dimens.MediumBoxHeight)
            .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
            .background(
                colorResource(id = R.color.blue_grey)
            ), contentAlignment = Alignment.Center
    ) {



        Text(text = text,
            fontSize = Dimens.MediumTextSize,
            style= MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.SemiBold,
            ))
    }
}