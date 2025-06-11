package com.example.bisamasak.menu.all_content

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
import com.example.bisamasak.ui.theme.OutfitTypography
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun RecipeSection(
    modifier: Modifier = Modifier,
    kategori: String,
    windowSize: WindowSizeClass,
    pagerState: PagerState,
    scope: CoroutineScope,
    recipes: List<RecipeContentResponse>,
    onRecipeClick: (Int) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = kategori,
                style = OutfitTypography.titleLarge,
            )
            Button(
                onClick = {
                    scope.launch {
                        val tabIndex  = MenuTabs.entries.indexOfFirst {
                            it.text.equals(kategori, ignoreCase = true)
                        }.takeIf { it >= 0 } ?: 0

                        pagerState.animateScrollToPage(tabIndex)
                    }
                },
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xE6ED453A),
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                ),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Text(
                    text = "Lihat Semua",
                    style = OutfitTypography.labelLarge
                )
            }
        }

        val filteredRecipes = recipes.filter { it.kategori.equals(kategori, ignoreCase = true) }

        when (windowSize.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                val randomRecipes = remember { filteredRecipes.shuffled().take(2) }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    randomRecipes.forEach { recipe ->
                        RecipeCard(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onRecipeClick(recipe.id_resep) },
                            foodImg = "http://192.168.100.97:8000/storage/${recipe.thumbnail ?: ""}",
                            foodName = recipe.judul_konten,
                            duration = recipe.durasi.toString(),
                        )
                    }
                }
            }
            WindowWidthSizeClass.Expanded -> {
                val randomRecipes = remember { filteredRecipes.shuffled().take(4) }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    randomRecipes.forEach { recipe ->
                        RecipeCard(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onRecipeClick(recipe.id_resep) },
                            foodImg = "http://192.168.100.96:8000/storage/${recipe.thumbnail ?: ""}",
                            foodName = recipe.judul_konten,
                            duration = recipe.durasi.toString(),
                        )
                    }
                }
            }
        }
    }
}