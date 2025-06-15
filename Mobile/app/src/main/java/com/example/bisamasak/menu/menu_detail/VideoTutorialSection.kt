package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bisamasak.component.VideoPlayer
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun VideoTutorialSection(
    videoUrl: String?,
    modifier: Modifier = Modifier,
    height: Dp = 200.dp
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Video Tutorial",
            style = OutfitTypography.titleLarge,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!videoUrl.isNullOrBlank()) {
                val context = LocalContext.current
                VideoPlayer(
                    context = context,
                    videoUrl = videoUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(12.dp))
                )
            } else {
                Text(
                    text = "Tidak ada video tutorial untuk resep ini",
                    style = OutfitTypography.titleMedium,
                    color = Color.LightGray
                )
            }
        }
    }
}