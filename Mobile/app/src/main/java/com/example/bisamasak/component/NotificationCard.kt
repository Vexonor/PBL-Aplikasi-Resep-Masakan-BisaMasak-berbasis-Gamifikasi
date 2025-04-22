package com.example.bisamasak.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bisamasak.data.dataContainer.NotificationItem
import com.example.bisamasak.ui.theme.OutfitTypography
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import com.example.bisamasak.R

@Composable
fun NotificationCard(item: NotificationItem, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if (item.title == "Masak apa ya hari ini?") {
                    navController.navigate("detailNotification_screen")
                }
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.LightGray, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.title,
                style = OutfitTypography.titleMedium,
                color = Color.Black
            )
            Text(
                text = item.message,
                style = OutfitTypography.titleSmall,
                color = Color.Gray,
                maxLines = 2
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "Detail",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}
