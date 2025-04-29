package com.example.bisamasak.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R

@Composable
fun BackButton(
    onClick: () -> Unit,
    tint: Color = Color(0xFFED453A),
    size: Dp = 24.dp
) {
    Image(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = "Back",
        modifier = Modifier
            .size(size)
            .clickable(onClick = onClick),
        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(tint)
    )
}