package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun CategorySection(
    category: String?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Kategori",
            style = OutfitTypography.titleLarge,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 30.dp, max = 100.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent,
                        contentColor = Color(0xFFED453A)
                    ),
                    border = BorderStroke(1.dp, Color(0xFFED453A)),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(percent = 50),
                    modifier = Modifier.wrapContentSize()
                ) {
                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp)
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = category?.replaceFirstChar { it.uppercase() } ?: "Tidak Ada Kategori",
                            style = OutfitTypography.titleMedium,
                        )
                    }
                }
            }
        }
    }
}