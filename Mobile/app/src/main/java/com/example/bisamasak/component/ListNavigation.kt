package com.example.bisamasak.component

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bisamasak.OnBoardingScreen
import com.example.bisamasak.SplashScreen
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
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
import com.example.bisamasak.menu.menu_detail.MenuDetailScreen
import com.example.bisamasak.menu.SearchScreen
import com.example.bisamasak.menu.TutorialDetailScreen
import com.example.bisamasak.profile.ProfileScreen
import com.example.bisamasak.profile.SettingContent
import com.example.bisamasak.profile.add_content.AddContentScreen
import com.example.bisamasak.profile.setting.account.AccountContent
import com.example.bisamasak.profile.setting.recently.RecentlyContent
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)

    val dataStore = remember { DataStoreManager(context) }
    var startDestination by remember { mutableStateOf<String?>(null) }
    val userLevelState = dataStore.userLevelFlow.collectAsState(initial = 1)
    val userLevel = userLevelState.value

    LaunchedEffect(true) {
        startDestination = "splash_screen"
    }

    if (startDestination != null) {
        NavHost(navController = navController, startDestination = startDestination!!) {
            composable("splash_screen") { SplashScreen(navController = navController, dataStore = dataStore) }
            composable("onBoarding_screen") {
                val coroutineScope = rememberCoroutineScope()

                OnBoardingScreen(navController = navController, onFinish = {
                    coroutineScope.launch {
                        dataStore.setOnboardingShow(true)
                        navController.navigate("login_screen") {
                            popUpTo("onBoarding_screen") { inclusive = true }
                        }
                    }
                })
            }
            composable("login_screen") { LoginScreen(navController = navController) }
            composable("register_screen") { RegisterScreen(navController = navController) }
            composable("forgot_screen") { ForgotScreen(navController = navController) }
            composable("new_password_screen") { NewPasswordScreen(navController = navController) }
            composable("practice_content") { PracticeContent(navController = navController, windowSize = windowSizeClass, userLevel = userLevel) }
            composable("today_content") { TodayContent(navController = navController, windowSize = windowSizeClass, userLevel = userLevel) }
            composable("latest_content") { LatestContent(navController = navController, windowSize = windowSizeClass, userLevel = userLevel) }
            composable("notification_screen") { NotificationContent(navController = navController) }
            composable("detailNotification_screen") {
                NotificationDetailContent(navController = navController)
            }
            composable("daily_screen") { DailyTaskContent(navController = navController) }

            composable("search_screen") {
                SearchScreen(navController = navController, windowSize = windowSizeClass, userLevel = userLevel)
            }
            //        Main Screen
            composable("home_screen") { HomeActivity(navController = navController) }
            composable("menu_screen") { MenuActivity(navController = navController) }
            composable("ingredient_screen") { IngredientActivity(navController = navController) }
            composable(
                route = "profile_screen?tab={tab}",
                arguments = listOf(navArgument("tab") {
                    defaultValue = "recipe"
                })
            ) { backStackEntry ->
                val tabArg = backStackEntry.arguments?.getString("tab") ?: "recipe"
                val initialTab = when (tabArg) {
                    "recipe" -> ProfileTabs.Recipe
                    "saved" -> ProfileTabs.Saved
                    "viewed" -> ProfileTabs.Viewed
                    "all" -> ProfileTabs.All_Profile
                    else -> ProfileTabs.All_Profile
                }
                ProfileScreen(
                    navController = navController,
                    initialTab = initialTab,
                    userLevel = userLevel
                )
            }

            //          Profil Setting
            composable("setting_screen") { SettingContent(navController = navController) }
            composable("account_screen") { AccountContent(navController = navController, dataStoreManager = dataStore) }
            composable("recently_screen") { RecentlyContent(navController = navController) }
            composable("add_content_screen?mode={mode}&id={id}" ,
                arguments = listOf(
                    navArgument("mode") { defaultValue = "create" },
                    navArgument("id") { nullable = true }
                )) { backStackEntry ->
                val mode = backStackEntry.arguments?.getString("mode") ?: "create"
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()

                val activity = LocalContext.current as Activity
                val sharedViewModel: RecipeContentViewModel = viewModel(viewModelStoreOwner = activity as ViewModelStoreOwner)

                AddContentScreen(navController = navController, viewModel = sharedViewModel, isEditMode = mode == "edit", editedRecipeId = id)
            }

            //        Ingredient Detail Screen
            composable("ingredient_detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                id?.let { IngredientDetailScreen(ingredientId = it, navController = navController, userLevel = userLevel) }
            }
            //        Tutorial Detail Screen
            composable("tutorial_detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                id?.let { TutorialDetailScreen(recipeId = it, navController = navController) }
            }
            //        Recipe Detail Screen
            composable("recipe_detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                id?.let { MenuDetailScreen(recipeId = it, navController = navController, userLevel = userLevel) }
            }
        }
    }
}
