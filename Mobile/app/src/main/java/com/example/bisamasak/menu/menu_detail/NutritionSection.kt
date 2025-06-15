package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bisamasak.data.dataContainer.Gizi
import androidx.compose.foundation.lazy.grid.items
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun NutritionSection(
    nutritionList: List<Gizi>,
    portion: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Nutrisi",
            style = OutfitTypography.titleLarge
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize()
        ) {
            items(nutritionList) { nutrient ->
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .wrapContentHeight(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(4.dp)
                    ) {
                        Text(
                            text = nutrient.nama_gizi,
                            style = OutfitTypography.labelLarge
                        )

                        val nutrientAmount = nutrient.jumlah.toFloatOrNull()?.times(portion)

                        Text(
                            text = if (nutrientAmount != null)
                                "± ${nutrientAmount.toInt()} ${nutrient.satuan}"
                            else
                                "${nutrient.jumlah} ${nutrient.satuan}",
                            style = OutfitTypography.labelMedium
                        )
                    }
                }
            }
        }
    }
}
