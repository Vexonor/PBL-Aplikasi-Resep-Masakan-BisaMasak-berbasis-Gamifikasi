package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.foundation.lazy.items
import com.example.bisamasak.data.dataContainer.Langkah
import com.example.bisamasak.data.utils.stepImageUrl
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun TutorialSection(
    steps: List<Langkah>,
    recipeId: Int,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Cara Memasak Resep Ini",
                style = OutfitTypography.titleLarge,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            Button(
                onClick = { navController.navigate("tutorial_detail/$recipeId") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xE6ED453A),
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Lihat Semua",
                    style = OutfitTypography.labelLarge
                )
            }
        }

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(steps) { step ->
                Column(
                    modifier = Modifier
                        .width(300.dp)
                        .height(250.dp)
                        .padding(horizontal = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    AsyncImage(
                        model = step.stepImageUrl,
                        contentDescription = "Langkah ${step.nomor_langkah}",
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Text(
                        text = "Langkah ${step.nomor_langkah}",
                        style = OutfitTypography.labelLarge
                    )

                    Text(
                        text = step.deskripsi_langkah,
                        style = OutfitTypography.bodyMedium,
                        maxLines = 2,
                        modifier = Modifier.height(50.dp)
                    )
                }
            }
        }
    }
}