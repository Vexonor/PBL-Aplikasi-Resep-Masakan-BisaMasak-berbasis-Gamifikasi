package com.example.bisamasak.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AppLogo() {
    Surface(
        modifier = Modifier.size(100.dp),
        shape = RoundedCornerShape(50.dp),
        shadowElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = com.example.bisamasak.R.drawable.ic_app_thumbnail),
            contentDescription = "Logo BisaMasak",
            modifier = Modifier.size(100.dp)
        )
    }
}
