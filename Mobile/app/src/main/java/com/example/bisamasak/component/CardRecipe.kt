package com.example.bisamasak.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun RecipeCard(foodImg: Int, foodName: String, duration: String, modifier: Modifier = Modifier) {
    Card (
        modifier = modifier
            .width(180.dp)
            .height(200.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color(0XFFFAFAFA),
            disabledContentColor = Color(0XFFFAFAFA)
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(width = 3.dp, color = Color(0XFFFAFAFA))
    ) {
        Column (
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(foodImg),
                    contentDescription = "Food Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                )
            }
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            Box (
                modifier = Modifier
                    .height(40.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    text = foodName,
                    style = OutfitTypography.titleMedium,
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row (
                    modifier = Modifier
                        .wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_timer),
                        contentDescription = "Timer",
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        text = "$duration menit",
                        style = OutfitTypography.labelMedium
                    )
                }
            }
        }
    }
}