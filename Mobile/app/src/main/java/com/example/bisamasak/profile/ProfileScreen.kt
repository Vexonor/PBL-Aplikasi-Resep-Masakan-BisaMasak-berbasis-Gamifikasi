package com.example.bisamasak.profile

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bisamasak.component.BottomBar
import com.example.bisamasak.component.ProfileTabs
import com.example.bisamasak.component.ProfilePortraitTab
import com.example.bisamasak.component.ProfileLandscapeTab
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.data.viewModel.SaveRecipeViewModel
import com.example.bisamasak.data.viewModel.UsersViewModel
import com.example.bisamasak.home.HeroSection
import com.example.bisamasak.profile.all_profile.AllProfileContent
import com.example.bisamasak.profile.viewed.LastViewedContent
import com.example.bisamasak.profile.recipe.MyRecipeContent
import com.example.bisamasak.profile.saved.SaveRecipeContent
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ProfileScreen(navController: NavController, initialTab: ProfileTabs = ProfileTabs.Recipe, userLevel: Int) {
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)

    ProfileComponent(
        navController = navController,
        windowSize = windowSizeClass,
        initialTab = initialTab,
        userLevel = userLevel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileComponent(navController: NavController, windowSize: WindowSizeClass, initialTab: ProfileTabs = ProfileTabs.Recipe, userLevel: Int) {
    val context = LocalContext.current
    val recipeViewModel: RecipeContentViewModel = viewModel(viewModelStoreOwner = LocalContext.current as ViewModelStoreOwner)
    val saveRecipeViewModel: SaveRecipeViewModel = viewModel(viewModelStoreOwner = LocalContext.current as ViewModelStoreOwner)
    val savedRecipes by saveRecipeViewModel.savedRecipes.collectAsState()
    val viewedRecipes = remember { mutableStateOf<List<RecipeContentResponse>>(emptyList()) }
    val dataStoreManager = remember { DataStoreManager(context) }
    val recipeList by recipeViewModel.recipeList.collectAsState()
    val allRecipeList by recipeViewModel.allRecipeList.collectAsState()

    val penggunaViewModel: UsersViewModel = viewModel()
    val pengguna by penggunaViewModel.pengguna.collectAsState()
    var idUser by remember { mutableLongStateOf(-1L) }

    val scope = rememberCoroutineScope()
    val pagerState = key(initialTab) {
        rememberPagerState(initialPage = initialTab.ordinal, pageCount = { ProfileTabs.entries.size })
    }

    var userId by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(Unit) {
        userId = dataStoreManager.getUserId().toInt()
        recipeViewModel.recipe()
        userId?.let { saveRecipeViewModel.getSavedRecipes(it) }
        idUser = dataStoreManager.getUserId()
        if (idUser != -1L) {
            penggunaViewModel.fetchPengguna(idUser)
        }
    }

    LaunchedEffect(recipeViewModel.uploadingRecipe, allRecipeList) {
        val uploaded = recipeViewModel.uploadingRecipe?.let { uploading ->
            allRecipeList.any {
                it.judul_konten == uploading.judul_konten &&
                        it.status_konten == "Terunggah"
            }
        } ?: false

        if (uploaded) {
            recipeViewModel.uploadingRecipe = null
            recipeViewModel.uploadProgress = 0f
        }
    }

    LaunchedEffect(userId, allRecipeList) {
        userId?.let {
            val viewedIds = dataStoreManager.getViewedRecipeIds(it.toLong())
            val matchedRecipes = viewedIds.mapNotNull { id ->
                allRecipeList.find { it.id_resep == id && it.status_konten == "Terunggah" }
            }
            viewedRecipes.value = matchedRecipes
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Profil",
                        style = OutfitTypography.titleLarge
                    )
                },
                actions = {
                    Button (
                        onClick = {
                            navController.navigate("setting_screen")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = Color.Transparent
                        ),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        elevation = null,
                        modifier = Modifier
                            .wrapContentSize()
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Setting",
                            tint = Color(0xFFED453A),
                            modifier = Modifier.size(32.dp)
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color.White,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color(0xFFED453A)
                )
            )
        },
        bottomBar = {
            BottomBar(
                selectedIndex = 3,
                onItemSelected = { index ->
                    scope.launch {
                        if (index == 3) {
                            pagerState.animateScrollToPage(ProfileTabs.All_Profile.ordinal)
                        } else {
                            when (index) {
                                0 -> navController.navigate("home_screen")
                                1 -> navController.navigate("menu_screen")
                                2 -> navController.navigate("ingredient_screen")
                            }
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    navController.navigate("add_content_screen")
                },
                containerColor = Color(0xFFED453A),
                shape = CircleShape,
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.padding(top = 16.dp))

            HeroSection(
                level = pengguna?.levelPengguna ?: 1,
                exp = pengguna?.poinLevel?.toFloat() ?: 0f,
                maxExp = 1000f,
                modifier = Modifier.padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.padding(top = 24.dp))

            when (windowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    ProfilePortraitTab(
                        pagerState = pagerState,
                        scope = scope
                    )
                }

                WindowWidthSizeClass.Expanded -> {
                    ProfileLandscapeTab(
                        pagerState = pagerState,
                        scope = scope
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                when (ProfileTabs.entries[page]) {
                    ProfileTabs.All_Profile -> {
                        userId?.let { uid ->
                            AllProfileContent(
                                pagerState = pagerState,
                                scope = scope,
                                recipeList = recipeList.filter { it.id_user == userId },
                                allRecipeList = allRecipeList,
                                navController = navController,
                                userId = uid.toLong(),
                                userLevel = userLevel
                            )
                        }
                    }

                    ProfileTabs.Recipe -> {
                        userId?.let { id ->
                            val uploadingRecipe = recipeViewModel.uploadingRecipe
                            val recipes = remember(uploadingRecipe, allRecipeList, userId) {
                                (uploadingRecipe?.takeIf { it.id_user == userId }?.let { listOf(it) } ?: emptyList()) +
                                        allRecipeList
                                            .filter { it.id_user == userId && it.id_resep != -1 }
                                            .distinctBy { it.id_resep }
                            }
                            MyRecipeContent(
                                windowSize = windowSize,
                                recipeList = recipes,
                                navController = navController,
                                uploadProgress = recipeViewModel.uploadProgress,
                                userLevel = userLevel
                            )
                        }
                    }

                    ProfileTabs.Saved -> {
                        userId?.let {
                            val selectedIndex = 1
                            LaunchedEffect(it, selectedIndex) {
                                if (ProfileTabs.entries[selectedIndex] == ProfileTabs.Saved) {
                                    saveRecipeViewModel.getSavedRecipes(it)
                                }
                            }

                            SaveRecipeContent(
                                navController = navController,
                                windowSize = windowSize,
                                savedRecipes = savedRecipes.sortedByDescending { it.saved_at },
                                userLevel = userLevel
                            )
                        }
                    }

                    ProfileTabs.Viewed -> {
                        LastViewedContent(
                            windowSize = windowSize,
                            navController = navController,
                            recipes = viewedRecipes.value,
                            userLevel = userLevel
                        )
                    }

                }
            }
        }
    }
}


