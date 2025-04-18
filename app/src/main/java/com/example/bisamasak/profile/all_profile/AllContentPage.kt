package com.example.bisamasak.profile.all_profile

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.bisamasak.profile.viewed.LastViewedSection
import com.example.bisamasak.profile.recipe.MyRecipeSection
import com.example.bisamasak.profile.saved.SaveRecipeSection

import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AllProfileContent(
    pagerState: PagerState,
    scope: CoroutineScope
) {
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = calculateWindowSizeClass(activity = activity)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        item {
            MyRecipeSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope
            )
        }
        item {
            SaveRecipeSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope
            )
        }
        item {
            LastViewedSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope
            )
        }

    }
}