package com.example.bisamasak

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun OnBoardingScreen (navController: NavController, modifier: Modifier = Modifier) {

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xE6ED453A)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row (
            modifier = modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Box (
                    modifier = Modifier
                        .size(90.dp)
                        .scale(5f)
                        .background(Color(0xFFFCB912), shape = CircleShape),
                )
                Box (
                    modifier = Modifier
                        .size(100.dp)
                        .scale(4f)
                        .absoluteOffset(x = 10.dp)
                        .border(color = Color(0xE6ED453A), width = 1.dp, shape = CircleShape),
                )
                Column (
                    modifier = modifier
                        .fillMaxHeight()
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text (
                        text = "BisaMasak",
                        style = OutfitTypography.titleLarge,
                        color = Color.White
                    )
                    Text (
                        text = "Aplikasi Resep Masakan",
                        style = OutfitTypography.titleMedium,
                        color = Color.White
                    )
                }
            }
        }

        Row (
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 12.dp)
                .height(150.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CardList()
        }

        Row (
            modifier = modifier.fillMaxWidth().weight(1f)
        ) {
            Box (
                modifier = modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Box (
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Box (
                        modifier = Modifier
                            .size(100.dp)
                            .scale(5f)
                            .background(Color(0xFFFCB912), shape = CircleShape)
                    ) {
                        Box (
                            modifier = Modifier
                                .size(100.dp)
                                .padding(top = 4.dp)
                                .absoluteOffset(x = 4.dp)
                                .border(color = Color(0xE6ED453A), width = 1.dp, shape = CircleShape)
                        )
                    }
                }

                Column (
                    modifier = modifier
                        .padding(top = 40.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text (
                        text = "Setelah makan malam yang enak, seseorang bisa memaafkan siapa pun, bahkan kerabatnya sendiri.",
                        style = OutfitTypography.titleLarge,
                        color = Color.White,
                        modifier = modifier
                            .padding(horizontal = 40.dp, vertical = 12.dp)
                            .widthIn(min = 250.dp, max = 330.dp),
                        textAlign = TextAlign.Center
                    )

                    Button(
                        onClick = {
                            navController.navigate("home_screen") {
                                popUpTo("onBoarding_screen") { inclusive = true }
                            }
                        },
                        modifier = Modifier
                            .width(150.dp),
                        enabled = true,
                        shape = CircleShape,
                        colors = ButtonColors(
                            containerColor = Color(0xE6ED453A),
                            contentColor = Color.White,
                            disabledContainerColor = Color(0x80ED453A),
                            disabledContentColor = Color.White
                        ),
                    ) {
                        Text(
                            text = "Mulai",
                            style = OutfitTypography.titleLarge
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Cards(image: Int, rotate: Float, scale: Float, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFE385),
        ),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier
            .size(width = 60.dp, height = 65.dp)
            .rotate(rotate)
            .scale(scale)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(3.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(3.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Food List",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(4.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(Color.White, shape = RoundedCornerShape(2.dp))
            )
        }
    }
}

@Composable
fun CardList () {
    val scaleCard1 = remember {
        Animatable(0f)
    }
    val scaleCard2 = remember {
        Animatable(0f)
    }
    val scaleCard3 = remember {
        Animatable(0f)
    }
    LaunchedEffect (key1 = true) {
        scaleCard2.animateTo(
            targetValue = 3f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        scaleCard1.animateTo(
            targetValue = 2f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        scaleCard3.animateTo(
            targetValue = 1.8f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(100.dp, Alignment.CenterHorizontally)
    ) {
        Cards(
            image = R.drawable.ic_food_1,
            rotate = -35f,
            scale = scaleCard1.value,
            modifier = Modifier.absoluteOffset(x = -25.dp)
        )
        Cards(
            image = R.drawable.ic_food_2,
            rotate = -15f,
            scale = scaleCard2.value,
        )
        Cards(
            image = R.drawable.ic_food_3,
            rotate = 25f,
            scale = scaleCard3.value,
            modifier = Modifier.absoluteOffset(x = 25.dp)
        )
    }
}