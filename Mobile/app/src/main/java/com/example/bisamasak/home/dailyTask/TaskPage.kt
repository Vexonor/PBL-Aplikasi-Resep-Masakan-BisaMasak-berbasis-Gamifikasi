package com.example.bisamasak.home.dailyTask

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.R
import com.example.bisamasak.component.TaskItem
import com.example.bisamasak.ui.theme.OutfitTypography
import com.example.bisamasak.component.BackButton
import com.example.bisamasak.data.provider.DataProvider.DailyTask

@Composable
fun DailyTaskContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        TopBar(navController)
        Spacer(modifier = Modifier.height(8.dp))

        Header()
        Spacer(modifier = Modifier.height(24.dp))

        HeroSection()
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Hari Ini",
            style = OutfitTypography.titleMedium,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        DailyTask.forEach { task ->
            TaskItem(
                iconResId = task.iconResId,
                title = task.title,
                points = task.points,
                onClaimClick = { /* TODO: Handle klaim */ }
            )
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton(onClick = { navController.popBackStack() })

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Tugas Harian",
            style = OutfitTypography.titleLarge,
            color = Color.Black
        )
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Hi Shafiq,",
            style = OutfitTypography.titleMedium,
            color = Color(0xFF748189)
        )
        Text(
            text = "Ayo lebih rajin memasak makanan sehat!",
            style = OutfitTypography.titleLarge,
            color = Color(0xFF748189)
        )
    }
}

@Composable
fun HeroSection(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 12.dp,
        color = Color(0xFFED453A)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(start = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Lakukan\n30 hari ",
                    style = OutfitTypography.titleLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "beruntun!",
                    style = OutfitTypography.titleLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

            Image(
                painter = painterResource(id = R.drawable.img_male_chef),
                contentDescription = "Hero Image",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(90.dp)
            )
        }
    }
}
