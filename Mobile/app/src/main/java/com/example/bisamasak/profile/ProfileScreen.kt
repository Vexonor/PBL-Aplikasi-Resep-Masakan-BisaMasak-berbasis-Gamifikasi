package com.example.bisamasak.profile

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bisamasak.component.BottomBar
import com.example.bisamasak.component.ProfileTabs
import com.example.bisamasak.component.ProfilePortraitTab
import com.example.bisamasak.component.ProfileLandscapeTab
import com.example.bisamasak.home.HeroSection
import com.example.bisamasak.profile.all_profile.AllProfileContent
import com.example.bisamasak.profile.viewed.LastViewedContent
import com.example.bisamasak.profile.recipe.MyRecipeContent
import com.example.bisamasak.profile.saved.SaveRecipeContent
import com.example.bisamasak.profile.ui.theme.BisaMasakTheme
import com.example.bisamasak.ui.theme.OutfitTypography

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

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ProfileActivity(navController: NavController) {
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ProfileComponent(
            navController = navController,
            windowSize = windowSizeClass
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileComponent(navController: NavController, windowSize: WindowSizeClass) {
    var selectedIndex by remember { mutableIntStateOf(3) }
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { ProfileTabs.entries.size })

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Profil",
                        style = OutfitTypography.titleLarge
                    )
                },
                actions = {
                    Button (
                        onClick = {
                            navController.navigate("setting_screen")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = Color.Transparent
                        ),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        elevation = null,
                        modifier = Modifier
                            .wrapContentSize()
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Setting",
                            tint = Color(0xFFED453A),
                            modifier = Modifier.size(32.dp)
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color.White,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color(0xFFED453A)
                )
            )
        },
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
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {},
                containerColor = Color(0xFFED453A),
                shape = CircleShape,
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.padding(top = 16.dp))

            HeroSection(
                level = 10,
                modifier = Modifier.padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.padding(top = 24.dp))

            when (windowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    ProfilePortraitTab(
                        pagerState = pagerState,
                        scope = scope
                    )
                }

                WindowWidthSizeClass.Expanded -> {
                    ProfileLandscapeTab(
                        pagerState = pagerState,
                        scope = scope
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                when (ProfileTabs.entries[page]) {
                    ProfileTabs.All_Profile -> {
                        AllProfileContent(
                            pagerState = pagerState,
                            scope = scope
                        )
                    }

                    ProfileTabs.Recipe -> {
                        MyRecipeContent(
                            pagerState = pagerState,
                            scope = scope,
                            windowSize = windowSize

                        )
                    }

                    ProfileTabs.Saved -> {
                        SaveRecipeContent(
                            pagerState = pagerState,
                            scope = scope,
                            windowSize = windowSize
                        )
                    }

                    ProfileTabs.Viewed -> {
                        LastViewedContent(
                            pagerState = pagerState,
                            scope = scope,
                            windowSize = windowSize
                        )
                    }

                }
            }
        }
    }
}


