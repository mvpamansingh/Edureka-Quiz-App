package com.example.edureka.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.edureka.R
import com.example.edureka.presentation.Utils.Dimens

@Preview
@Composable
fun HomeHeader()
{
    Box (
        modifier= Modifier
            .fillMaxWidth()
            .height(Dimens.HomeTopBoxHeight)
            .background(
                color = colorResource(id = R.color.dark_slate_blue), shape = RoundedCornerShape(
                    bottomStart = Dimens.ExtraLargeCornerRadius,
                    bottomEnd = Dimens.ExtraLargeCornerRadius
                )

            )){

        Row (modifier= Modifier
            .fillMaxWidth()
            .padding(top = Dimens.LargePadding),

            horizontalArrangement =Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){

            Icon(painterResource(id = R.drawable.baseline_menu_open_24),
                contentDescription = "",
                tint = colorResource(id = R.color.blue_grey)
                ,modifier= Modifier.weight(1f).
                size(Dimens.MediumIconSize)
            )

            Text(text = "Edureka",
                modifier= Modifier.weight(3.5f),
                color = colorResource(id = R.color.blue_grey),
                style= MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                fontSize = Dimens.LargeTextSize
            )
            Icon(painterResource(id = R.drawable.baseline_account_box_24),
                contentDescription = "",
                modifier= Modifier.weight(1f).
            size(Dimens.MediumIconSize),
                tint = colorResource(id = R.color.blue_grey))

        }
    }
}