package com.example.bisamasak.menu.all_content

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
import com.example.bisamasak.menu.breakfast.BreakFastSection
import com.example.bisamasak.menu.dinner.DinnerSection
import com.example.bisamasak.menu.lunch.LunchSection
import com.example.bisamasak.menu.snack.SnackSection
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AllContent(
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
            BreakFastSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope
            )
        }
        item {
            LunchSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope
            )
        }
        item {
            SnackSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope
            )
        }
        item {
            DinnerSection(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                windowSize = windowSizeClass,
                pagerState = pagerState,
                scope = scope
            )
        }
    }
}