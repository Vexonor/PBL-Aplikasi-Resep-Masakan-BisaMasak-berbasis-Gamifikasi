package com.example.bisamasak.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun TaskItem(
    iconResId: Int,
    title: String,
    points: Int,
    isClaimed: Boolean,
    onClaimClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFF5F5F5),
            modifier = Modifier.size(50.dp)
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = OutfitTypography.titleMedium,
            )
            Text(
                text = "$points Poin",
                style = OutfitTypography.bodyLarge,
                color = Color.Gray
            )
        }

        Button(
            onClick = onClaimClick,
            enabled = !isClaimed,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC6A0)),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 2.dp),
            modifier = Modifier.height(32.dp)
        ) {
            Text(
                text = if (isClaimed) "Sudah Diklaim" else "Klaim",
                style = OutfitTypography.titleMedium,
                color = Color(0xFFED453A)
            )
        }
    }
}
