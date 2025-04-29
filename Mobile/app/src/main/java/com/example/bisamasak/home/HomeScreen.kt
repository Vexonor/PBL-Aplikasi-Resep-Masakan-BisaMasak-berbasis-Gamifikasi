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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.component.BottomBar
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

    var selectedIndex by remember { mutableIntStateOf(0) }

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
                        3 -> navController.navigate("profile_screen")
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
                name = "Shafiq",
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .wrapContentSize(),
                navController = navController,
            )
            HeroSection(
                level = 10,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            CategoriesRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                windowSize = windowSizeClass
            )
            PracticeRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                navController = navController,
                windowSize = windowSizeClass
            )
            TodayRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                navController = navController,
                windowSize = windowSizeClass
            )
            LatestRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                navController = navController,
                windowSize = windowSizeClass
            )
        }
    }
}


