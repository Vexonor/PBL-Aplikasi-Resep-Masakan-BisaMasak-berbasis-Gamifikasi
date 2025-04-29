package com.example.bisamasak.component

import android.app.Activity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.OnBoardingScreen
import com.example.bisamasak.SplashScreen
import com.example.bisamasak.home.HomeActivity
import com.example.bisamasak.home.dailyTask.DailyTaskContent
import com.example.bisamasak.home.latestRecipe.LatestContent
import com.example.bisamasak.home.notification.NotificationContent
import com.example.bisamasak.home.notificationDetail.NotificationDetailContent
import com.example.bisamasak.home.practiceRecipe.PracticeContent
import com.example.bisamasak.home.todayRecipe.TodayContent
import com.example.bisamasak.ingredient.IngredientActivity
import com.example.bisamasak.ingredient.IngredientDetailScreen
import com.example.bisamasak.login_register.ForgotScreen
import com.example.bisamasak.login_register.LoginScreen
import com.example.bisamasak.login_register.NewPasswordScreen
import com.example.bisamasak.login_register.RegisterScreen
import com.example.bisamasak.menu.MenuActivity
import com.example.bisamasak.menu.MenuDetailScreen
import com.example.bisamasak.menu.SearchScreen
import com.example.bisamasak.menu.TutorialDetailScreen
import com.example.bisamasak.profile.ProfileActivity
import com.example.bisamasak.profile.SettingContent
import com.example.bisamasak.profile.add_content.AddContentScreen
import com.example.bisamasak.profile.setting.account.AccountContent
import com.example.bisamasak.profile.setting.recently.RecentlyContent

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)

    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") { SplashScreen(navController = navController) }
        composable("onBoarding_screen") { OnBoardingScreen(navController = navController) }
        composable("login_screen") { LoginScreen(navController = navController) }
        composable("register_screen") { RegisterScreen(navController = navController) }
        composable("forgot_screen") { ForgotScreen(navController = navController) }
        composable("new_password_screen") { NewPasswordScreen(navController = navController) }
        composable("practice_content") { PracticeContent(navController = navController) }
        composable("today_content") { TodayContent(navController = navController) }
        composable("latest_content") { LatestContent(navController = navController) }
        composable("notification_screen") { NotificationContent(navController = navController) }
        composable("detailNotification_screen") {
            NotificationDetailContent(navController = navController)
        }
        composable("daily_screen") { DailyTaskContent(navController = navController) }

        composable("search_screen") {
            SearchScreen(navController = navController, windowSize = windowSizeClass)
        }
        //        Main Screen
        composable("home_screen") { HomeActivity(navController = navController) }
        composable("menu_screen") { MenuActivity(navController = navController) }
        composable("ingredient_screen") { IngredientActivity(navController = navController) }
        composable("profile_screen") { ProfileActivity(navController = navController) }

        //          Profil Setting
        composable("setting_screen") { SettingContent(navController = navController) }
        composable("account_screen") { AccountContent(navController = navController) }
        composable("recently_screen") { RecentlyContent(navController = navController) }
        composable("add_content_screen") { AddContentScreen(navController = navController) }

        //        Ingredient Detail Screen
        composable("ingredient_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            id?.let { IngredientDetailScreen(ingredientId = it, navController = navController) }
        }
        //        Tutorial Detail Screen
        composable("tutorial_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            id?.let { TutorialDetailScreen(recipeId = it, navController = navController) }
        }
        //        Recipe Detail Screen
        composable("recipe_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            id?.let { MenuDetailScreen(recipeId = it, navController = navController) }
        }
    }
}
