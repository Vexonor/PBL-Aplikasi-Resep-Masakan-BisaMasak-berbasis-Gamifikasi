package com.example.bisamasak

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bisamasak.component.Navigation
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.DailyTaskViewModel
import com.example.bisamasak.data.viewModel.DailyTaskViewModelFactory
import com.example.bisamasak.ui.theme.BisaMasakTheme
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
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
    val context = LocalContext.current
    val dailyTaskViewModelFactory = remember { DailyTaskViewModelFactory(DataStoreManager(context)) }
    val dailyTaskViewModel: DailyTaskViewModel = viewModel(factory = dailyTaskViewModelFactory)

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
        scale.animateTo(
            targetValue = 1.3f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )

        delay(2000)

        val lastActive = dataStore.getLastActive()
        val currentTime = System.currentTimeMillis()
        val sevenDaysInMillis = 7 * 24 * 60 * 60 * 1000L

        if (currentTime - lastActive > sevenDaysInMillis) {
            dataStore.setLogin(false)
        }

        val isShown = dataStore.isOnboardingShow()
        val isLogin = dataStore.isLogin()

        if (isLogin) {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val today = sdf.format(Date())
            val lastLoginDate = dataStore.getLastLoginDate()
            if (lastLoginDate != today) {
                dataStore.setLastLoginDate(today)

                val loginTask = dailyTaskViewModel.taskList.value
                    .find { it.title.equals("Login hari ini", ignoreCase = true) }
                loginTask?.let {
                    dailyTaskViewModel.claimTaskPoints(it)
                }
            }
        }

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