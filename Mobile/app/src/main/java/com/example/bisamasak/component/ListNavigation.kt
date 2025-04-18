package com.example.bisamasak.component

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.OnBoardingScreen
import com.example.bisamasak.SplashScreen
import com.example.bisamasak.home.HomeActivity
import com.example.bisamasak.home.practiceRecipe.PracticeContent
import com.example.bisamasak.home.todayRecipe.TodayContent
import com.example.bisamasak.home.latestRecipe.LatestContent
import com.example.bisamasak.ingredient.IngredientActivity
import com.example.bisamasak.login_register.ForgotScreen
import com.example.bisamasak.login_register.LoginScreen
import com.example.bisamasak.login_register.NewPasswordScreen
import com.example.bisamasak.login_register.RegisterScreen
import com.example.bisamasak.menu.MenuActivity
import com.example.bisamasak.profile.ProfileActivity
import com.example.bisamasak.profile.setting.account.AccountContent
import com.example.bisamasak.profile.setting.recently.RecentlyContent
import com.example.bisamasak.profile.setting.setting.SettingContent


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "recently_screen") {
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
        composable("latest_content") {
            LatestContent(navController = navController)
        }
//        Main Screen
        composable("home_screen") {
            HomeActivity(navController = navController)
        }
        composable("menu_screen") {
            MenuActivity(navController = navController)
        }
        composable("ingredient_screen") {
            IngredientActivity(navController = navController)
        }
        composable("profile_screen") {
            ProfileActivity(navController = navController)
        }
        composable("setting_screen") {
            SettingContent(navController = navController)
        }
        composable("account_screen") {
            AccountContent(navController = navController)
        }
        composable("recently_screen") {
            RecentlyContent(navController = navController)
        }
    }
}