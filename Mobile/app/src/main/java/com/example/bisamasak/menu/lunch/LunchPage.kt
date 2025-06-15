package com.example.bisamasak.menu.lunch

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bisamasak.component.EmptyContent
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.component.ShimmerCard
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.utils.imageUrl
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun LunchContent(
    windowSize: WindowSizeClass,
    onRecipeClick: (Int) -> Unit
) {
//    Recipe Model
    val viewModel: RecipeContentViewModel = viewModel()
    val recipes = viewModel.recipeList.collectAsState().value
    val recipesByCategory = recipes.groupBy { it.kategori.trim().lowercase() }
    val isLoading = viewModel.isLoading

    LaunchedEffect(Unit) {
        viewModel.recipe()
    }

    if (isLoading) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 24.dp)
        ) {
            items(8) {
                ShimmerCard()
            }
        }
    } else {
        val categories = recipesByCategory["makan siang"] ?: emptyList()
        if (categories.isEmpty()) {
            EmptyContent(text = "Konten Masih Belum Tersedia")
        } else {
            when (windowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    PortraitLunchContent(categories, onRecipeClick)
                }

                WindowWidthSizeClass.Expanded -> {
                    LandscapeLunchContent(categories, onRecipeClick)
                }
            }
        }
    }
}

@Composable
fun PortraitLunchContent(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        item (
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Makan Siang",
                    style = OutfitTypography.titleLarge,
                )
            }
        }
        items(recipes) { recipe ->
            RecipeCard(
                foodImg = recipe.imageUrl,
                foodName = recipe.judul_konten,
                duration = recipe.durasi.toString(),
                modifier = Modifier
                    .clickable{ onRecipeClick(recipe.id_resep) }
            )
        }
    }
}

@Composable
fun LandscapeLunchContent(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        item (
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Makan Siang",
                    style = OutfitTypography.titleLarge,
                )
            }
        }
        items(recipes) { recipe ->
            RecipeCard(
                foodImg = recipe.imageUrl,
                foodName = recipe.judul_konten,
                duration = recipe.durasi.toString(),
                modifier = Modifier
                    .clickable{ onRecipeClick(recipe.id_resep) }
            )
        }
    }
}