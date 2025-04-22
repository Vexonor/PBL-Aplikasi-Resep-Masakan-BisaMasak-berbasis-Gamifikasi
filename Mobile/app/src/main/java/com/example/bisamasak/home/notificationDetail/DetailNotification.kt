package com.example.bisamasak.home.notificationDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.component.BackButton
import com.example.bisamasak.component.RecipeCard
import com.example.bisamasak.data.provider.DataProvider
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun NotificationDetailContent(navController: NavController) {
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
            Text(
                text = "Pesan",
                style = OutfitTypography.headlineSmall.copy(color = Color.Black)
            )
        }
//
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Surface(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                color = Color.LightGray
            ) {

            }
            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Masak apa ya hari ini?",
                    style = OutfitTypography.titleMedium,
                    color = Color.Black
                )
                Text(
                    text = "Cobain rekomendasi resep dibawah ini. Jangan lupa recook, ya!",
                    style = OutfitTypography.bodyLarge,
                    color = Color.Gray
                )
            }

            Text(
                text = "Hari Ini",
                style = OutfitTypography.labelMedium,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Bubur Ayam Istimewa",
                style = OutfitTypography.bodyLarge,
                color = Color.Black
            )
            Text(
                text = "Bubur ayam, hidangan sarapan favorit masyarakat Indonesia, kini bisa Anda buat sendiri di rumah dengan resep istimewa ini. Teksturnya yang lembut dan gurih, berpadu dengan suwiran ayam yang lezat, serta berbagai topping yang menggugah selera, menjadikan bubur ayam ini pilihan tepat untuk memulai hari Anda.",
                style = OutfitTypography.bodyLarge,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Resep Masakan Terkait",
                style = OutfitTypography.titleLarge,
                color = Color.Black
            )

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(DataProvider.ResepCemilan) { recipe ->
                    RecipeCard(
                        foodImg = recipe.foodImg,
                        foodName = recipe.foodName,
                        duration = recipe.duration.toString(),
                    )
                }
            }
        }
    }
}
