package com.example.bisamasak.home.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.component.BackButton
import com.example.bisamasak.data.provider.DataProvider
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun NotificationContent(navController: NavController) {
    val sections = DataProvider.sections

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            BackButton(onClick = { navController.popBackStack() })
            Spacer(modifier = Modifier.width(16.dp))
            androidx.compose.material3.Text(
                text = "Notifikasi",
                style = OutfitTypography.headlineSmall.copy(color = Color.Black)
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {

            sections.forEach { (label, items) ->
                item {
                    NotificationSection(
                        label = label,
                        items = items,
                        navController = navController
                    )
                }
            }
        }
    }
}
