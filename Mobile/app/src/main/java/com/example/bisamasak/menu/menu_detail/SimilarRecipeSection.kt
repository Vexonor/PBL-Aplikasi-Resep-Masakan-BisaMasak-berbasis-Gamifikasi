package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.utils.imageUrl
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun SimilarRecipeSection(
    similarRecipes: List<RecipeContentResponse>,
    onRecipeClick: (Int) -> Unit,
    userLevel: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Resep Masakan Terkait",
            style = OutfitTypography.titleLarge,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        if (similarRecipes.isEmpty()) {
            Text(
                text = "Tidak ada resep yang serupa",
                style = OutfitTypography.bodyMedium,
                color = Color.Gray
            )
        } else {
            val sortedRecipes = similarRecipes.sortedBy { it.terbuka_di_level }
            LazyRow {
                items(sortedRecipes) { recipe ->
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
    }
}