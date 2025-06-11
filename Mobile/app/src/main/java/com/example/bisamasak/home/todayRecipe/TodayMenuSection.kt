package com.example.bisamasak.home.todayRecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.component.ShimmerCard
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun TodayRecipe(navController: NavController, modifier: Modifier = Modifier, windowSize: WindowSizeClass, viewModel: RecipeContentViewModel) {
    val recipes = viewModel.recipeList.collectAsState().value
    val isLoading = viewModel.isLoading

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
                text = "Menu Hari Ini",
                style = OutfitTypography.titleLarge,
            )
            Button(
                onClick = {
                    navController.navigate("today_content")
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
        if (isLoading) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
                modifier = Modifier
                    .heightIn(max = 500.dp)
                    .background(Color.White)
                    .padding(horizontal = 24.dp)
            ) {
                items(2) {
                    ShimmerCard(
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        } else {
            val onRecipeClick: (Int) -> Unit = { recipeId ->
                navController.navigate("recipe_detail/$recipeId")
            }
            when(windowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    PortraitToday(recipes, onRecipeClick)
                }

                WindowWidthSizeClass.Expanded -> {
                    LandscapeToday(recipes, onRecipeClick)
                }
            }
        }
    }
}

@Composable
fun PortraitToday(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit) {
    val recipe = recipes.shuffled().take(2)
    if (recipe.isEmpty()) {
        Text(
            text = "Belum ada resep tersedia",
            style = OutfitTypography.labelMedium,
            modifier = Modifier.padding(16.dp)
        )
        return
    }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        recipe.forEach { recipe ->
            RecipeCard(
                foodImg = "http://192.168.100.97:8000/storage/${recipe.thumbnail ?: ""}",
                foodName = recipe.judul_konten,
                duration = recipe.durasi.toString(),
                modifier = Modifier
                    .weight(1f)
                    .clickable{ onRecipeClick(recipe.id_resep) }
            )
        }
    }
}

@Composable
fun LandscapeToday(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit) {
    val recipe = recipes.shuffled().take(4)
    if (recipe.isEmpty()) {
        Text(
            text = "Belum ada resep praktis yang tersedia",
            style = OutfitTypography.labelMedium,
            modifier = Modifier.padding(16.dp)
        )
        return
    }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        recipe.forEach { recipe ->
            RecipeCard(
                foodImg = "http://192.168.100.96:8000/storage/${recipe.thumbnail ?: ""}",
                foodName = recipe.judul_konten,
                duration = recipe.durasi.toString(),
                modifier = Modifier
                    .weight(1f)
                    .clickable{ onRecipeClick(recipe.id_resep) }
            )
        }
    }
}