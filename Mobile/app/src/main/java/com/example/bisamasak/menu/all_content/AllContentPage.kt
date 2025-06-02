package com.example.bisamasak.menu.all_content

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bisamasak.component.ShimmerCard
import com.example.bisamasak.data.utils.RecipeCategory
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.data.viewModel.RecipeViewModel
import com.example.bisamasak.menu.breakfast.BreakFastSection
import com.example.bisamasak.menu.dinner.DinnerSection
import com.example.bisamasak.menu.lunch.LunchSection
import com.example.bisamasak.menu.snack.SnackSection
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AllContent(
    pagerState: PagerState,
    scope: CoroutineScope,
    navController: NavController
) {
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)


//    Recipe Model
    val recipeViewModel: RecipeContentViewModel = viewModel()
    val isLoading = recipeViewModel.isLoading

    LaunchedEffect(Unit) {
        recipeViewModel.recipe()
    }

    if (isLoading) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 80.dp, top = 10.dp),
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 24.dp)
        ) {
            items(8) {
                ShimmerCard()
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            val groupedRecipes = recipeViewModel.recipeList.groupBy { it.kategori }

            groupedRecipes.forEach { (kategori, recipes) ->
                item {
                    RecipeSection(
                        modifier = Modifier
                            .padding(horizontal = 24.dp),
                        windowSize = windowSizeClass,
                        pagerState = pagerState,
                        kategori = kategori,
                        scope = scope,
                        recipes = recipes,
                        onRecipeClick = { id ->
                            navController.navigate("recipe_detail/$id")
                        }
                    )
                }
            }
        }
    }
}