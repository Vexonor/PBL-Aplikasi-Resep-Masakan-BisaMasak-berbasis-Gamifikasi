package com.example.bisamasak.menu

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.component.BottomBar
import com.example.bisamasak.component.LandscapeTab
import com.example.bisamasak.component.MenuTabs
import com.example.bisamasak.component.PortraitTab
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.UsersViewModel
import com.example.bisamasak.menu.all_content.AllContent
import com.example.bisamasak.menu.breakfast.BreakfastContent
import com.example.bisamasak.menu.dinner.DinnerContent
import com.example.bisamasak.menu.lunch.LunchContent
import com.example.bisamasak.menu.snack.SnackContent
import com.example.bisamasak.menu.ui.theme.BisaMasakTheme
import com.example.bisamasak.ui.theme.OutfitTypography

class MenuScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BisaMasakTheme(darkTheme = false) {
                val navController = rememberNavController()
                MenuActivity(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MenuActivity(navController: NavController) {
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)
    val dataStore = remember { DataStoreManager(context) }

    val penggunaViewModel: UsersViewModel = viewModel()
    val pengguna by penggunaViewModel.pengguna.collectAsState()
    var idUser by remember { mutableLongStateOf(-1L) }

    LaunchedEffect(Unit) {
        idUser = dataStore.getUserId()
        if (idUser != -1L) {
            penggunaViewModel.fetchPengguna(idUser)
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MenuComponent(
            navController = navController,
            windowSize = windowSizeClass,
            userLevel = pengguna?.levelPengguna ?: 1
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MenuComponent(navController: NavController, windowSize: WindowSizeClass, userLevel: Int) {
    var selectedIndex by remember { mutableIntStateOf(1) }

//    Pager State
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { MenuTabs.entries.size })

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Menu",
                        style = OutfitTypography.headlineMedium
                    )
                },
                actions = {
                    Button (
                        onClick = {
                            navController.navigate("search_screen")
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
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search",
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
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                    when (index) {
                        0 -> navController.navigate("home_screen")
                        1 -> navController.navigate("menu_screen")
                        2 -> navController.navigate("ingredient_screen")
                        3 -> navController.navigate("profile_screen?tab=all")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            when(windowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    PortraitTab(
                        pagerState = pagerState,
                        scope = scope
                    )
                }
                WindowWidthSizeClass.Expanded -> {
                    LandscapeTab(
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
                when(MenuTabs.entries[page]) {
                    MenuTabs.All -> {
                        AllContent(
                            pagerState = pagerState,
                            scope = scope,
                            navController = navController,
                            userLevel = userLevel
                        )
                    }
                    MenuTabs.Breakfast -> {
                        BreakfastContent(
                            windowSize = windowSize,
                            onRecipeClick = { id ->
                                navController.navigate("recipe_detail/$id")
                            },
                            userLevel = userLevel
                        )
                    }
                    MenuTabs.Lunch -> {
                        LunchContent(
                            windowSize = windowSize,
                            onRecipeClick = { id ->
                                navController.navigate("recipe_detail/$id")
                            },
                            userLevel = userLevel
                        )
                    }
                    MenuTabs.Snack -> {
                        SnackContent(
                            windowSize = windowSize,
                            onRecipeClick = { id ->
                                navController.navigate("recipe_detail/$id")
                            },
                            userLevel = userLevel
                        )
                    }
                    MenuTabs.Dinner -> {
                        DinnerContent(
                            windowSize = windowSize,
                            onRecipeClick = { id ->
                                navController.navigate("recipe_detail/$id")
                            },
                            userLevel = userLevel
                        )
                    }
                }

            }
        }
    }
}