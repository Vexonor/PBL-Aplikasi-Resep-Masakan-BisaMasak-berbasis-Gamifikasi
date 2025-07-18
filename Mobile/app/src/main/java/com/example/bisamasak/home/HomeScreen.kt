package com.example.bisamasak.home

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.component.BottomBar
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.data.viewModel.UsersViewModel
import com.example.bisamasak.home.latestRecipe.LatestRecipe
import com.example.bisamasak.home.practiceRecipe.PracticeRecipe
import com.example.bisamasak.home.todayRecipe.TodayRecipe
import com.example.bisamasak.home.ui.theme.BisaMasakTheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BisaMasakTheme(darkTheme = false) {
                val navController = rememberNavController()
                HomeActivity(
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun HomeActivity(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeComponent(navController = navController)
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun HomeComponent(navController: NavController) {
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)

    val dataStore = remember { DataStoreManager(context) }
    val viewModel: RecipeContentViewModel = viewModel()
    val penggunaViewModel: UsersViewModel = viewModel()

    val pengguna by penggunaViewModel.pengguna.collectAsState()
    var idUser by remember { mutableLongStateOf(-1L) }

    var selectedIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        viewModel.recipe()
    }

    LaunchedEffect(Unit) {
        idUser = dataStore.getUserId()
        if (idUser != -1L) {
            penggunaViewModel.fetchPengguna(idUser)
        }
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        containerColor = Color.White,
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
            Header(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .wrapContentSize(),
                navController = navController,
            )
            HeroSection(
                level = pengguna?.levelPengguna ?: 1,
                exp = pengguna?.poinLevel?.toFloat() ?: 0f,
                maxExp = 1000f,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            PracticeRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                navController = navController,
                windowSize = windowSizeClass,
                viewModel = viewModel,
                userLevel = pengguna?.levelPengguna ?: 1
            )
            TodayRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                navController = navController,
                windowSize = windowSizeClass,
                viewModel = viewModel,
                userLevel = pengguna?.levelPengguna ?: 1
            )
            LatestRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                navController = navController,
                windowSize = windowSizeClass,
                viewModel = viewModel,
                userLevel = pengguna?.levelPengguna ?: 1
            )
        }
    }
}


