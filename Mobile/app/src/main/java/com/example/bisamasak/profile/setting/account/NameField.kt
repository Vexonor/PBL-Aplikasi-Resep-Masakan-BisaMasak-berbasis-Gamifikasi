package com.example.bisamasak.profile.setting.account

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun NameField(name: String, onNameChange: (String) -> Unit) {
    Text(
        text = "Nama",
        style = OutfitTypography.titleMedium,
        color = Color.Black,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
    )
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions.Default,
        textStyle = OutfitTypography.titleMedium,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xFFED453A),
            focusedBorderColor = Color(0xFFED453A)
        )
    )
}
