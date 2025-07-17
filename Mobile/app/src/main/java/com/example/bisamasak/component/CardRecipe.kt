package com.example.bisamasak.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun RecipeCard(
    foodImg: String,
    foodName: String,
    duration: String,
    modifier: Modifier = Modifier,
    isUnlocked: Boolean,
    requiredLevel: Int,
    onClick: (() -> Unit)? = null,
) {
    val alpha = if (isUnlocked) 1f else 0.15f

    Box(
        modifier = Modifier
            .width(180.dp)
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Card (
            modifier = modifier
                .matchParentSize()
                .graphicsLayer { this.alpha = alpha }
                .then(
                    if (isUnlocked && onClick != null) Modifier.clickable { onClick() }
                    else Modifier
                ),
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
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(foodImg)
                            .addHeader("User-Agent", "Mozilla/5.0")
                            .crossfade(true)
                            .build(),
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
                            .matchParentSize(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
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

        if (!isUnlocked) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Locked",
                        tint = Color(0xFFED453A),
                        modifier = Modifier.size(40.dp)
                    )
                    Text(
                        text = "Terbuka di Level $requiredLevel",
                        color = Color.Black,
                        style = OutfitTypography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}