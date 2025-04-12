package com.example.bisamasak.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitTypography

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun CategoriesRecipe(modifier: Modifier = Modifier, windowSize: WindowSizeClass) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Kategori Resep",
                style = OutfitTypography.titleLarge,
            )
            Button(
                onClick = {},
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
                PortraitList()
            }
            WindowWidthSizeClass.Expanded -> {
                LandscapeList()
            }
        }

    }
}

@Composable
fun CategoriesList (image: Int, name: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFAFAFA),
            contentColor = Color.Black
        ),
        modifier = modifier
            .width(160.dp)
            .height(50.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Food Categories",
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = name,
                style = OutfitTypography.labelLarge
            )
        }
    }
}

@Composable
fun PortraitList() {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        item {
            CategoriesList (
                image = R.drawable.ic_breakfast,
                name = "Sarapan"
            )
        }
        item {
            CategoriesList (
                image = R.drawable.ic_lunch,
                name = "Makan Siang"
            )
        }
        item {
            CategoriesList (
                image = R.drawable.ic_snack,
                name = "Cemilan"
            )
        }
        item {
            CategoriesList (
                image = R.drawable.ic_dinner,
                name = "Makan Malam"
            )
        }
    }
}

@Composable
fun LandscapeList() {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        item {
            CategoriesList (
                image = R.drawable.ic_breakfast,
                name = "Sarapan"
            )
        }
        item {
            CategoriesList (
                image = R.drawable.ic_lunch,
                name = "Makan Siang"
            )
        }
        item {
            CategoriesList (
                image = R.drawable.ic_snack,
                name = "Cemilan"
            )
        }
        item {
            CategoriesList (
                image = R.drawable.ic_dinner,
                name = "Makan Malam"
            )
        }
    }
}