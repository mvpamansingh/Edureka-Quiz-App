package com.example.edureka.presentation.quiz.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.edureka.R
import com.example.edureka.presentation.Utils.Dimens

@Composable
fun QuizInterface(
    onOptionSelected: (Int) -> Unit,
    qNumber:Int,
    modifier: Modifier= Modifier
)
{



    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    )
    {

        Column(modifier= Modifier.wrapContentHeight())
        {
            
            Row(modifier= Modifier.fillMaxWidth()){
                
                
                Text(
                    modifier = Modifier.weight(1f)
                    ,text = "$qNumber",
                    color= colorResource(id = R.color.blue_grey),
                    fontSize = Dimens.SmallTextSize
                    )
                
                Text(
                    modifier = Modifier.weight(9f)
                    ,text ="Which Cartoon do you see ?",
                    color= colorResource(id = R.color.blue_grey),
                    fontSize = Dimens.MediumTextSize)
                
            }

            Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))

            Column(modifier= Modifier.padding(
                horizontal = 16.dp
            )) {

                val option = listOf(
                    "A" to "Pokemon",
                    "B" to "Beyblade",
                    "C" to "Oswald",
                    "D" to "Dragon Tales"
                )
                Column {

                    option.forEachIndexed{index, pair ->

                        if(pair.second.isNotEmpty())
                        {
                            QuizOptions(
                                optionNumber= pair.first,
                                option= pair.second,
                                selected= false,
                                onOptionClick= {onOptionSelected(index)},
                                onUnselectedOption= {onOptionSelected(-1)}
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
                    }
                }
                Spacer(modifier = Modifier.height(Dimens.ExtraLargeSpacerHeight))


            }
        }

    }

}