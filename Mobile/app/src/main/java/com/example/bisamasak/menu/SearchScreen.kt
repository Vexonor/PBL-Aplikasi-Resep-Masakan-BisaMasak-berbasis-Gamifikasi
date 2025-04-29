package com.example.bisamasak.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.component.ShimmerCard
import com.example.bisamasak.data.dataContainer.Recipe
import com.example.bisamasak.data.provider.DataProvider
import com.example.bisamasak.data.utils.RecipeCategory
import com.example.bisamasak.data.viewModel.RecipeViewModel
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun SearchScreen(
    navController: NavController,
    windowSize: WindowSizeClass
) {
    val viewModel: RecipeViewModel = viewModel()
    val searchQuery = remember { mutableStateOf("") }
    val searchResult = viewModel.searchResult.collectAsState().value

    Scaffold(
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 24.dp, top = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        navController.navigate("menu_screen")
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
                TextField(
                    value = searchQuery.value,
                    onValueChange = {
                        searchQuery.value = it
                        viewModel.smartSearch(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "Cari Resep, Bahan-bahan...",
                            style = OutfitTypography.labelLarge
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = Color(0xFFED453A),
                            modifier = Modifier
                                .size(24.dp)
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0x1A748189),
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFED453A),
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color(0xFFED453A),
                    )
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            if (searchQuery.value.isNotBlank()){
                if (searchResult.isEmpty()){
                    Text(
                        text = "Tidak ada hasil",
                        style = OutfitTypography.titleMedium
                    )
                }
                else{
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = "Hasil Pencarianmu",
                            style = OutfitTypography.titleLarge,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                        val isLoading = viewModel.isLoading.collectAsState().value

                        LaunchedEffect(Unit) {
                            viewModel.fetchAllCategories()
                        }

                        if (isLoading) {
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
                                modifier = Modifier
                                    .background(Color.White)
                                    .padding(horizontal = 16.dp)
                            ) {
                                items(8) {
                                    ShimmerCard()
                                }
                            }
                        } else {
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
                                modifier = Modifier
                                    .background(Color.White)
                            ) {
                                items(searchResult) { recipe ->
                                    RecipeCard(
                                        foodImg = recipe.image,
                                        foodName = recipe.title,
                                        duration = recipe.readyInMinutes.toString(),
                                        modifier = Modifier
                                            .clickable{
                                                navController.navigate("recipe_detail/${recipe.id}")
                                            }
                                    )
                                }
                            }
                        }
                    }
                }
            }
            else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = "Spesial Untukmu",
                        style = OutfitTypography.titleLarge,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                    //    Recipe Model
                    val viewModel: RecipeViewModel = viewModel()
                    val recipesByCategory = viewModel.recipesByCategory.collectAsState().value
                    val isLoading = viewModel.isLoading.collectAsState().value

                    LaunchedEffect(Unit) {
                        viewModel.fetchAllCategories()
                    }

                    if (isLoading) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
                            modifier = Modifier
                                .background(Color.White)
                                .padding(horizontal = 16.dp)
                        ) {
                            items(8) {
                                ShimmerCard()
                            }
                        }
                    } else {
                        when(windowSize.widthSizeClass) {
                            WindowWidthSizeClass.Compact -> {
                                PortraitSpesial(recipes = recipesByCategory[RecipeCategory.CEMILAN] ?: emptyList())
                            }

                            WindowWidthSizeClass.Expanded -> {
                                LandscapeSpesial(recipes = recipesByCategory[RecipeCategory.CEMILAN] ?: emptyList())
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PortraitSpesial(recipes: List<Recipe>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
        modifier = Modifier
            .background(Color.White)
    ) {
        items(DataProvider.ResepCemilan) { recipe ->
            RecipeCard(
                foodImg = recipe.foodImg,
                foodName = recipe.foodName,
                duration = recipe.duration.toString(),
            )
        }
        items(recipes) { recipe ->
            RecipeCard(
                foodImg = recipe.image,
                foodName = recipe.title,
                duration = recipe.readyInMinutes.toString(),
            )
        }
    }
}

@Composable
fun LandscapeSpesial(recipes: List<Recipe>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        items(DataProvider.ResepCemilan) { recipe ->
            RecipeCard(
                foodImg = recipe.foodImg,
                foodName = recipe.foodName,
                duration = recipe.duration.toString(),
            )
        }
        items(recipes) { recipe ->
            RecipeCard(
                foodImg = recipe.image,
                foodName = recipe.title,
                duration = recipe.readyInMinutes.toString(),
            )
        }
    }
}