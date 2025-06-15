package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun HeaderSection(menudetails: RecipeContentResponse?) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp).fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = menudetails?.judul_konten.orEmpty(),
                style = OutfitTypography.titleLarge,
                modifier = Modifier.width(250.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_timer),
                    contentDescription = "Timer",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "${menudetails?.durasi} menit",
                    style = OutfitTypography.labelLarge
                )
            }
        }

        Column(
            modifier = Modifier.heightIn(min = 50.dp, max = 200.dp)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = menudetails?.deskripsi_konten.orEmpty(),
                style = OutfitTypography.bodyLarge
            )
        }
    }
}