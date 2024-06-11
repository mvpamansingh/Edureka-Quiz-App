package com.example.edureka.presentation.quiz.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edureka.R
import com.example.edureka.presentation.Utils.Dimens

@Preview
@Composable
fun ShimmerEffectQuizInterface()
{
    Column{
        Row(
            modifier= Modifier.padding(Dimens.SmallPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier
                .width(20.dp)
                .height(40.dp)
                .weight(1f)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
            )

            Spacer(modifier = Modifier.width(5.dp))
            Box(modifier = Modifier
                .width(20.dp)
                .height(40.dp)
                .weight(9f)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
            )
        }
        Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))

        Column(
            modifier= Modifier.padding(
                horizontal = 16.dp
            )
        ) {


            Box(modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.MediumBoxHeight)
                .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                .shimmerEffect())

            Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.MediumBoxHeight)
                .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                .shimmerEffect())

            Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.MediumBoxHeight)
                .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                .shimmerEffect())
            Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.MediumBoxHeight)
                .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                .shimmerEffect())


            Spacer(modifier = Modifier.height(Dimens.ExtraLargeSpacerHeight))

            Row {
                Box(
                    modifier= Modifier
                        .weight(0.5f)
                        .fillMaxWidth()
                        .height(Dimens.MediumBoxHeight)
                        .clip(RoundedCornerShape(Dimens.LargeLottieAnimeSize))
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.width(Dimens.SmallSpacerWidth))
                Box(
                    modifier= Modifier
                        .weight(0.5f)
                        .fillMaxWidth()
                        .height(Dimens.MediumBoxHeight)
                        .clip(RoundedCornerShape(Dimens.LargeLottieAnimeSize))
                        .shimmerEffect()
                )
            }
        }
    }
}











fun Modifier.shimmerEffect()= composed{

    val transition = rememberInfiniteTransition(label ="")






    val alpha = transition.animateFloat(
        initialValue = 0.2f
        , targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    ).value
    this.background(color= colorResource(id = R.color.blue_grey).copy(alpha= alpha))
}

