package com.example.bisamasak.profile.saved

import androidx.compose.foundation.background
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
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.dataContainer.SavedRecipe
import com.example.bisamasak.data.utils.imageUrl
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun SaveRecipeContent(
    navController: NavController,
    windowSize: WindowSizeClass,
    savedRecipes: List<SavedRecipe>,
    userLevel: Int
) {
    val onRecipeClick: (Int) -> Unit = { recipeId ->
        navController.navigate("recipe_detail/$recipeId")
    }

    val combinedList = savedRecipes
        .sortedByDescending { it.saved_at }
        .map { it.recipe }

    if (combinedList.isNotEmpty()) {
        when (windowSize.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                PortraitSavedRecipeContent(combinedList, onRecipeClick, userLevel)
            }
            WindowWidthSizeClass.Expanded -> {
                LandscapeSavedRecipeContent(combinedList, onRecipeClick, userLevel)
            }
        }
    } else {
        EmptyContent(text = "Anda belum menyimpan resep apapun")
    }
}

@Composable
fun PortraitSavedRecipeContent(
    recipes: List<RecipeContentResponse>,
    onRecipeClick: (Int) -> Unit,
    userLevel: Int
) {
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
        item(span = { GridItemSpan(maxLineSpan) }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Resep Disimpan",
                    style = OutfitTypography.titleLarge,
                )
            }
        }

        items(recipes.size) { index ->
            val recipe = recipes[index]
            val unlocked = userLevel >= recipe.terbuka_di_level
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RecipeCard(
                    foodImg = recipe.imageUrl,
                    foodName = recipe.judul_konten,
                    duration = recipe.durasi.toString(),
                    isUnlocked = unlocked,
                    requiredLevel = recipe.terbuka_di_level,
                    onClick = if (unlocked) { { onRecipeClick(recipe.id_resep) } } else null,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


@Composable
fun LandscapeSavedRecipeContent(
    recipes: List<RecipeContentResponse>,
    onRecipeClick: (Int) -> Unit,
    userLevel: Int
) {
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
        item(span = { GridItemSpan(maxLineSpan) }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Resep Disimpan",
                    style = OutfitTypography.titleLarge,
                )
            }
        }

        items(recipes.size) { index ->
            val recipe = recipes[index]
            val unlocked = userLevel >= recipe.terbuka_di_level
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RecipeCard(
                    foodImg = recipe.imageUrl,
                    foodName = recipe.judul_konten,
                    duration = recipe.durasi.toString(),
                    isUnlocked = unlocked,
                    requiredLevel = recipe.terbuka_di_level,
                    onClick = if (unlocked) { { onRecipeClick(recipe.id_resep) } } else null,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
