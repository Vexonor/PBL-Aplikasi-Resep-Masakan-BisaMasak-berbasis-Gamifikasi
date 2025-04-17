package com.example.bisamasak.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PortraitTab(
    pagerState: PagerState,
    scope: CoroutineScope
) {
    val selectedTabsIndex = remember { derivedStateOf { pagerState.currentPage } }

    ScrollableTabRow(
        selectedTabIndex = selectedTabsIndex.value,
        containerColor = Color.White,
        contentColor = Color(0xFFED453A),
        edgePadding = 16.dp,
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabsIndex.value])
                    .height(4.dp)
                    .background(Color(0xFFED453A), shape = CircleShape)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        MenuTabs.entries.forEachIndexed { index, currentTab ->
            Tab(
                selected = selectedTabsIndex.value == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(currentTab.ordinal)
                    }
                },
                text = {
                    Text(
                        text = currentTab.text,
                        style = OutfitTypography.labelLarge
                    )
                }
            )
        }
    }
}

@Composable
fun LandscapeTab(
    pagerState: PagerState,
    scope: CoroutineScope
) {
    val selectedTabsIndex = remember { derivedStateOf { pagerState.currentPage } }

    TabRow(
        selectedTabIndex = selectedTabsIndex.value,
        containerColor = Color.White,
        contentColor = Color(0xFFED453A),
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabsIndex.value])
                    .height(4.dp)
                    .background(Color(0xFFED453A), shape = CircleShape)
            )
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        MenuTabs.entries.forEachIndexed { index, currentTab ->
            Tab(
                selected = selectedTabsIndex.value == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = currentTab.text,
                        style = OutfitTypography.labelLarge
                    )
                }
            )
        }
    }

}

enum class MenuTabs(
    val text: String
) {
    All("Semua"),
    Breakfast("Sarapan"),
    Lunch("Makan Siang"),
    Snack("Cemilan"),
    Dinner("Makan Malam")
}