package com.example.bisamasak.menu.lunch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.data.provider.DataProvider
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.CoroutineScope

@Composable
fun LunchContent(
    pagerState: PagerState,
    scope: CoroutineScope,
    windowSize: WindowSizeClass
) {
    when(windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            PortraitLunchContent()
        }
        WindowWidthSizeClass.Expanded -> {
            LandscapeLunchContent()
        }
    }
}

@Composable
fun PortraitLunchContent() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
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
        items(DataProvider.ResepMakanSiang) { recipe ->
            RecipeCard(
                foodImg = recipe.foodImg,
                foodName = recipe.foodName,
                duration = recipe.duration.toString(),
            )
        }
    }
}

@Composable
fun LandscapeLunchContent() {
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
        items(DataProvider.ResepMakanSiang) { recipe ->
            RecipeCard(
                foodImg = recipe.foodImg,
                foodName = recipe.foodName,
                duration = recipe.duration.toString(),
            )
        }
    }
}