package com.example.bisamasak.home.notification

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bisamasak.component.NotificationCard
import com.example.bisamasak.data.dataContainer.NotificationItem
import com.example.bisamasak.ui.theme.OutfitTypography
import androidx.navigation.NavController

@Composable
fun NotificationSection(
    label: String,
    items: List<NotificationItem>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            style = OutfitTypography.titleMedium,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                NotificationCard(item = item, navController = navController)
            }
        }
    }
}
