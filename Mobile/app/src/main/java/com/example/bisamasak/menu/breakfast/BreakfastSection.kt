package com.example.bisamasak.menu.breakfast

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bisamasak.component.MenuTabs
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.data.dataContainer.Recipe
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun BreakFastSection(
    modifier: Modifier = Modifier,
    windowSize: WindowSizeClass,
    pagerState: PagerState,
    scope: CoroutineScope,
    recipes: List<Recipe>,
    onRecipeClick: (Int) -> Unit
) {
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
                text = "Sarapan",
                style = OutfitTypography.titleLarge,
            )
            Button(
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(MenuTabs.Breakfast.ordinal)
                    }
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
                PortraitBreakFast(recipes, onRecipeClick)
            }
            WindowWidthSizeClass.Expanded -> {
                LandscapeBreakFast(recipes, onRecipeClick)
            }
        }
    }
}

@Composable
fun PortraitBreakFast(recipes: List<Recipe>, onRecipeClick: (Int) -> Unit) {
    val randomRecipes = remember { recipes.shuffled().take(2) }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        randomRecipes.forEach { recipe ->
            RecipeCard(
                modifier = Modifier
                    .weight(1f)
                    .clickable{ onRecipeClick(recipe.id) },
                foodImg = recipe.image,
                foodName = recipe.title,
                duration = recipe.readyInMinutes.toString(),
            )
        }
    }
}

@Composable
fun LandscapeBreakFast(recipes: List<Recipe>, onRecipeClick: (Int) -> Unit) {
    val randomRecipes = remember { recipes.shuffled().take(4) }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        randomRecipes.forEach { recipe ->
            RecipeCard(
                modifier = Modifier
                    .weight(1f)
                    .clickable{ onRecipeClick(recipe.id) },
                foodImg = recipe.image,
                foodName = recipe.title,
                duration = recipe.readyInMinutes.toString(),
            )
        }
    }
}