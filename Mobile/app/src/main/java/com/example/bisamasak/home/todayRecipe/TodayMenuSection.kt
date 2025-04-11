package com.example.bisamasak.home.todayRecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R
import com.example.bisamasak.home.practiceRecipe.RecipeCard
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun TodayRecipe(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Menu BisaMasak Hari Ini",
                style = OutfitTypography.titleLarge,
            )
            Button(
                onClick = {},
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xE6ED453A),
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Lihat Semua",
                    style = OutfitTypography.labelLarge
                )
            }
        }

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RecipeCard(
                foodImg = R.drawable.img_food_4,
                foodName = "Susu Kurma Madu",
                duration = "20"
            )
            RecipeCard(
                foodImg = R.drawable.ic_food_2,
                foodName = "Perkedel Jagung Tempe",
                duration = "30"
            )
        }
    }
}