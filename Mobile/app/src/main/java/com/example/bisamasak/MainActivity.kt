package com.example.bisamasak

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.component.Navigation
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.ui.theme.BisaMasakTheme
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BisaMasakTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun SplashScreen (navController: NavController, modifier: Modifier = Modifier, dataStore: DataStoreManager) {
    val image = painterResource(R.drawable.ic_app_logo)
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.3f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("onBoarding_screen")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xE6ED453A)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            modifier = Modifier
                .scale(scale.value)
                .size(150.dp),
            contentDescription = null
        )
        Text(
            text = "BisaMasak",
            style = OutfitTypography.displayMedium,
            color = Color.White
        )
    }
    LaunchedEffect(key1 = true) {
        delay(2000)
        val isShown = dataStore.isOnboardingShow()
        val isLogin = dataStore.isLogin()

        when {
            !isShown -> {
                navController.navigate("onBoarding_screen") {
                    popUpTo("splash_screen") { inclusive = true }
                }
            }
            isLogin -> {
                navController.navigate("home_screen") {
                    popUpTo("splash_screen") { inclusive = true }
                }
            }
            else -> {
                navController.navigate("login_screen") {
                    popUpTo("splash_screen") { inclusive = true }
                }
            }
        }
    }
}