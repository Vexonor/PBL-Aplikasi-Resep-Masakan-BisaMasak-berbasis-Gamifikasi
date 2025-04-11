package com.example.bisamasak.home

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.BottomBar
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

@Composable
fun HomeComponent(navController: NavController) {
    var selectedIndex by remember { mutableIntStateOf(0) }
//    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }
//    val dummyResults = listOf("Sate Ayam", "Nasi Goreng", "Mie Ayam")

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        containerColor = Color.White,
        bottomBar = {
            BottomBar(selectedIndex) { index ->
                selectedIndex = index
            }
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
                    .wrapContentSize()
            )
            HeroSection(
                level = 10,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
//            Search(
//                textFieldState = searchQuery,
//                onSearch = { query ->
//                    Log.d("Search", "User searched: $query")
//                },
//                searchResults = dummyResults,
//                modifier = Modifier
//            )
            CategoriesRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            )
            PracticeRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                navController = navController
            )
            TodayRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            )
            LatestRecipe(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            )
        }
    }
}
