package com.example.bisamasak.profile.saved

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.component.ProfileTabs
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.dataContainer.SavedRecipe
import com.example.bisamasak.data.utils.imageUrl
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SaveRecipeSection(
    modifier: Modifier = Modifier,
    windowSize: WindowSizeClass,
    pagerState: PagerState,
    scope: CoroutineScope,
    savedRecipes: List<SavedRecipe>,
    navController: NavController,
    userLevel: Int
) {
    val onRecipeClick: (Int) -> Unit = { recipeId ->
        navController.navigate("recipe_detail/$recipeId")
    }

    val combinedList = savedRecipes
        .sortedByDescending { it.saved_at }
        .map { it.recipe }

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
                text = "Resep disimpan",
                style = OutfitTypography.titleLarge,
            )
            Button(
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(ProfileTabs.Saved.ordinal)
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
        if (combinedList.isNotEmpty()) {
        when(windowSize.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                PortraitSaveRecipeSection(combinedList, onRecipeClick, userLevel)
            }
            WindowWidthSizeClass.Expanded -> {
                LandscapeSaveRecipeSection(combinedList, onRecipeClick, userLevel)
            }
        }
        } else {
            Text(
                text = "Anda belum menyimpan resep apapun",
                style = OutfitTypography.bodyMedium
            )
        }
    }
}

@Composable
fun PortraitSaveRecipeSection(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit, userLevel: Int) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        recipes.take(2).forEach { recipe ->
            val unlocked = userLevel >= recipe.terbuka_di_level
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

@Composable
fun LandscapeSaveRecipeSection(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit, userLevel: Int) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        recipes.take(4).forEach { recipe ->
            val unlocked = userLevel >= recipe.terbuka_di_level
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