package com.example.bisamasak.home.practiceRecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.navigation.NavController
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.component.ShimmerCard
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.utils.imageUrl
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun PracticeContent(navController: NavController, windowSize: WindowSizeClass, userLevel: Int) {
    val viewModel: RecipeContentViewModel = viewModel()
    val recipe = viewModel.recipeList.collectAsState().value
    val practiceRecipe = recipe
        .filter { it.durasi < 20 }
        .sortedBy { it.terbuka_di_level }
    val isLoading = viewModel.isLoading

    LaunchedEffect(Unit) {
        viewModel.recipe()
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 24.dp, top = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        navController.navigate("home_screen")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp),
                    elevation = null
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFFED453A),
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Resep Praktis",
                    style = OutfitTypography.titleLarge
                )
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
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
                    items(8) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            ShimmerCard(
                                modifier = Modifier
                                    .weight(1f)
                            )
                        }
                    }
                }
            } else {
                val onRecipeClick: (Int) -> Unit = { recipeId ->
                    navController.navigate("recipe_detail/$recipeId")
                }
                if (practiceRecipe.isNotEmpty()) {
                    when(windowSize.widthSizeClass) {
                        WindowWidthSizeClass.Compact -> {
                            Portrait(practiceRecipe, onRecipeClick, userLevel)
                        }
                        WindowWidthSizeClass.Expanded -> {
                            Landscape(practiceRecipe, onRecipeClick, userLevel)
                        }
                    }
                } else {
                    Text(
                        text = "Tidak ada resep praktis",
                        modifier = Modifier.padding(16.dp),
                        style = OutfitTypography.labelLarge
                    )
                }
            }
        }
    }
}

@Composable
fun Portrait(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit, userLevel: Int) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
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
fun Landscape(recipes: List<RecipeContentResponse>, onRecipeClick: (Int) -> Unit, userLevel: Int) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
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