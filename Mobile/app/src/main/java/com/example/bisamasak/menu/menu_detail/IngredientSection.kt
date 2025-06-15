package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bisamasak.data.dataContainer.BahanResep
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun IngredientSection(
    ingredients: List<BahanResep>,
    portion: Int
) {
    val totalIngredients = ingredients.size

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Bahan-bahan",
                style = OutfitTypography.titleLarge,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Text(
                text = "$totalIngredients Bahan",
                style = OutfitTypography.labelLarge,
                color = androidx.compose.ui.graphics.Color.Gray
            )
        }

        Column {
            ingredients.forEach { ingredient ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = ingredient.bahan_masak_table?.nama_bahan?.replaceFirstChar { it.uppercase() }
                            ?: "Tidak Ada Nama Bahan",
                        style = OutfitTypography.labelLarge
                    )

                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        val jumlahDasar = parseFractionalAmount(ingredient.jumlah_bahan)
                        val jumlahPerPorsi = jumlahDasar?.times(portion)

                        Text(
                            text = jumlahPerPorsi?.toString() ?: ingredient.jumlah_bahan,
                            style = OutfitTypography.labelLarge
                        )
                        Text(
                            text = ingredient.satuan_bahan.replaceFirstChar { it.uppercase() },
                            style = OutfitTypography.labelLarge,
                            textAlign = TextAlign.End,
                            modifier = Modifier.width(80.dp)
                        )
                    }
                }
            }
        }
    }
}