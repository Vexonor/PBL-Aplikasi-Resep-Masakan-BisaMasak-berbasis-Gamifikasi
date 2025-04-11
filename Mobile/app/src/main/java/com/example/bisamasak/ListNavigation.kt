package com.example.bisamasak

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.forgot.ForgotScreen
import com.example.bisamasak.home.HomeActivity
import com.example.bisamasak.home.practiceRecipe.PracticeContent
import com.example.bisamasak.home.todayRecipe.TodayContent
import com.example.bisamasak.kategori_spesial.KategoriSpesialUntukmu
import com.example.bisamasak.kategori_terbaru.KategoriResepTerbaru
import com.example.bisamasak.login.LoginScreen
import com.example.bisamasak.new_password.NewPasswordScreen
import com.example.bisamasak.register.RegisterScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("onBoarding_screen") {
            OnBoardingScreen(navController = navController)
        }
        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("register_screen") {
            RegisterScreen(navController = navController)
        }
        composable("forgot_screen") {
            ForgotScreen(navController = navController)
        }
        composable("new_password_screen") {
            NewPasswordScreen(navController = navController)
        }
        composable("practice_content") {
            PracticeContent(navController = navController)
        }
        composable("today_content") {
            TodayContent(navController = navController)
        }
        composable("kategori_terbaru") {
            KategoriResepTerbaru(navController = navController)
        }
        composable("kategori_spesial") {
            KategoriSpesialUntukmu(navController = navController)
        }
        composable("home_screen") {
            HomeActivity(navController = navController)
        }
    }
}