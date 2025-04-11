package com.example.bisamasak.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.component.BottomBar
import com.example.bisamasak.profile.ui.theme.BisaMasakTheme

class ProfileScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BisaMasakTheme {
                val navController = rememberNavController()
                ProfileActivity(navController = navController)
            }
        }
    }
}

@Composable
fun ProfileActivity(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ProfileComponent(navController = navController)
    }
}

@Composable
fun ProfileComponent(navController: NavController) {
    var selectedIndex by remember { mutableIntStateOf(3) }

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

        }
    }
}