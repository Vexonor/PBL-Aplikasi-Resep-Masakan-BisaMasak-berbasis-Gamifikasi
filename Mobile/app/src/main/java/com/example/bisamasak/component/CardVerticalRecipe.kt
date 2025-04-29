package com.example.bisamasak.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import coil.compose.AsyncImage
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun VerticalRecipeCard(
    foodImg: String,
    foodName: String,
    description: String,
    duration: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color(0XFFFAFAFA),
            disabledContentColor = Color(0XFFFAFAFA)
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(width = 3.dp, color = Color(0XFFFAFAFA)),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = foodName,
                    style = OutfitTypography.titleMedium,
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = OutfitTypography.bodyMedium,
                    color = Color.Black,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_timer),
                        contentDescription = "Timer Icon",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$duration menit",
                        style = OutfitTypography.labelMedium
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            AsyncImage(
                model = foodImg,
                contentDescription = "Food Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}
