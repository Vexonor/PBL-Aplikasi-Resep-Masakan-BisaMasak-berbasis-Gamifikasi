package com.example.bisamasak.profile.recipe

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
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.component.EmptyContent
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.component.UploadingCard
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.utils.imageUrl
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun MyRecipeContent(
    navController: NavController,
    windowSize: WindowSizeClass,
    recipeList: List<RecipeContentResponse>,
    uploadProgress: Float
) {
    val onRecipeClick: (Int) -> Unit = { recipeId ->
        navController.navigate("recipe_detail/$recipeId")
    }

    val combinedList = recipeList
        .distinctBy { it.id_resep }
        .sortedWith (
            compareByDescending<RecipeContentResponse> { it.status_konten == "Uploading" }
                .thenByDescending { it.created_at }
        )

    if (combinedList.isNotEmpty()) {
        when(windowSize.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                PortraitMyRecipeContent(combinedList, onRecipeClick, uploadProgress)
            }
            WindowWidthSizeClass.Expanded -> {
                LandscapeMyRecipeContent(combinedList, onRecipeClick, uploadProgress)
            }
        }
    } else {
        EmptyContent(text = "Anda belum mengupload resep apapun")
    }
}

@Composable
fun PortraitMyRecipeContent(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit, uploadProgress: Float) {
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
                    text = "Resep Saya",
                    style = OutfitTypography.titleLarge,
                )
            }
        }
        items(recipes.size) { index ->
            val recipe = recipes[index]
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (recipe.status_konten == "Uploading") {
                    UploadingCard(recipe = recipe, progress = uploadProgress)
                } else {
                    RecipeCard(
                        foodImg = recipe.imageUrl,
                        foodName = recipe.judul_konten,
                        duration = recipe.durasi.toString(),
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onRecipeClick(recipe.id_resep) }
                    )
                }
            }
        }
    }
}

@Composable
fun LandscapeMyRecipeContent(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit, uploadProgress: Float) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
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
                    text = "Resep Saya",
                    style = OutfitTypography.titleLarge,
                )
            }
        }
        items(recipes.size) { index ->
            val recipe = recipes[index]
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (recipe.status_konten == "Uploading") {
                    UploadingCard(recipe = recipe, progress = uploadProgress)
                } else {
                    RecipeCard(
                        foodImg = recipe.imageUrl,
                        foodName = recipe.judul_konten,
                        duration = recipe.durasi.toString(),
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onRecipeClick(recipe.id_resep) }
                    )
                }
            }
        }
    }
}