package com.example.bisamasak.home.todayRecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bisamasak.dataresep.DataProvider
import com.example.bisamasak.home.practiceRecipe.RecipeCard
import com.example.bisamasak.ui.theme.OutfitFont


@Composable
fun TodayContent(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFFED453A),
                    modifier = Modifier
                        .size(24.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Menu BisaMasak Hari Ini",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = OutfitFont,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(19.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    top = 10.dp,
                    bottom = 80.dp
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                items(DataProvider.ResepBisaMasak) { recipe ->
                    RecipeCard(
                        foodImg = recipe.foodImg,
                        foodName = recipe.foodName,
                        duration = recipe.duration.toString(),
                    )
                }
            }
        }
    }
}