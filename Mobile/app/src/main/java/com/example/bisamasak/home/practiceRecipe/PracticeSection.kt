package com.example.bisamasak.home.practiceRecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.data.provider.DataProvider
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun PracticeRecipe(navController: NavController, modifier: Modifier = Modifier, windowSize: WindowSizeClass) {
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
                text = "Resep Praktis",
                style = OutfitTypography.titleLarge,
            )
            Button(
                onClick = {
                    navController.navigate("practice_content")
                },
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
        when(windowSize.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                PortraitPractice()
            }
            WindowWidthSizeClass.Expanded -> {
                LandscapePractice()
            }
        }
    }
}

@Composable
fun PortraitPractice() {
    val randomRecipes = rememberSaveable {
        DataProvider.ResepPraktis.shuffled().take(2)
    }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        randomRecipes.forEach { recipe ->
            RecipeCard(
                modifier = Modifier.weight(1f),
                foodImg = recipe.foodImg,
                foodName = recipe.foodName,
                duration = recipe.duration.toString(),
            )
        }
    }
}

@Composable
fun LandscapePractice() {
    val randomRecipes = rememberSaveable {
        DataProvider.ResepPraktis.shuffled().take(4)
    }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        randomRecipes.forEach { recipe ->
            RecipeCard(
                modifier = Modifier.weight(1f),
                foodImg = recipe.foodImg,
                foodName = recipe.foodName,
                duration = recipe.duration.toString(),
            )
        }
    }
}