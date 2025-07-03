package com.example.bisamasak.profile.all_profile

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.SaveRecipeViewModel
import com.example.bisamasak.profile.viewed.LastViewedSection
import com.example.bisamasak.profile.recipe.MyRecipeSection
import com.example.bisamasak.profile.saved.SaveRecipeSection

import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AllProfileContent(
    pagerState: PagerState,
    scope: CoroutineScope,
    recipeList: List<RecipeContentResponse>,
    allRecipeList: List<RecipeContentResponse>,
    userId: Long,
    navController: NavController,
    userLevel: Int
) {
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)

    val saveRecipeViewModel: SaveRecipeViewModel = viewModel(viewModelStoreOwner = LocalContext.current as ViewModelStoreOwner)
    val savedRecipes by saveRecipeViewModel.savedRecipes.collectAsState()

    val dataStoreManager = remember { DataStoreManager(context) }
    val viewedRecipes = remember { mutableStateListOf<RecipeContentResponse>() }

    LaunchedEffect(allRecipeList, userId) {
        val viewedIds = dataStoreManager.getViewedRecipeIds(userId)
        val matchedRecipes = viewedIds.mapNotNull { id ->
            allRecipeList.find { it.id_resep == id && it.status_konten == "Terunggah" }
        }
        viewedRecipes.clear()
        viewedRecipes.addAll(matchedRecipes)
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        item {
            MyRecipeSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope,
                recipeList = recipeList.filter { it.status_konten != "Uploading" },
                navController = navController,
                userLevel = userLevel
            )
        }
        item {
            SaveRecipeSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope,
                savedRecipes = savedRecipes.sortedByDescending { it.saved_at },
                navController = navController,
                userLevel = userLevel
            )
        }
        item {
            LastViewedSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope,
                recipes = viewedRecipes,
                navController = navController,
                userLevel = userLevel
            )
        }

    }
}