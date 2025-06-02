package com.example.bisamasak.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.R
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun Header(navController: NavController, modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val dataStore = remember { DataStoreManager(context) }
    var userName by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        userName = dataStore.getUserName()
    }

    Row (
        modifier = modifier
            .background(color = Color(0xE6ED453A))
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier = Modifier
                .padding(16.dp)
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hi! ${if (userName.isNotBlank()) userName.replaceFirstChar { it.uppercase() } else "Chef"}",
                style = OutfitTypography.titleLarge,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Apa yang ingin kamu masak hari ini?",
                style = OutfitTypography.titleMedium,
                color = Color.White
            )
        }

        Row (
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_calendar),
                contentDescription = "Calendar",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        navController.navigate("daily_screen")
                    }
            )
            Spacer(modifier = Modifier.size(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = "Bell",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        navController.navigate("notification_screen")
                    }
            )
        }
    }
}