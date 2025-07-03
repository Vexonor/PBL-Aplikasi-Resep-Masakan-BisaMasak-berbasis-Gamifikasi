package com.example.bisamasak.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun HeroSection(level: Int, exp: Float, maxExp: Float, modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color(0XFFFAFAFA), shape = RoundedCornerShape(12.dp)),
        shadowElevation = 12.dp,
        shape = RoundedCornerShape(8.dp),
        color = Color(0XFFFAFAFA)
    ) {
        Row (
            modifier = modifier
                .fillMaxSize()
        ) {
            Box (modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.img_male_chef),
                    contentDescription = "Hero",
                    modifier = Modifier.size(90.dp)
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Level $level",
                    style = OutfitTypography.titleLarge,
                    color = Color.Black
                )
                Row (
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_coin),
                        contentDescription = "Exp Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    ExpBar(exp, maxExp)
                }
            }
        }
    }
}

@Composable
fun ExpBar(exp: Float, maxExp: Float) {
    val progress = exp / maxExp
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${exp.toInt()}",
            style = OutfitTypography.labelLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        LinearProgressIndicator(
            progress = { progress.coerceIn(0f, 1f) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .height(8.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(24.dp)),
            color = Color(0xE6ED453A),
            trackColor = Color.LightGray,
        )
    }
}