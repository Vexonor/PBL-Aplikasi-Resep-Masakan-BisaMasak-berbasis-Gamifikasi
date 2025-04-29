package com.example.bisamasak.profile.add_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun TextInput(label: String, singleLine: Boolean, keyboardType: KeyboardType, modifier: Modifier = Modifier) {
    val customTextSelectionColors  = TextSelectionColors(
        handleColor = Color(0xFFED453A),
        backgroundColor = Color.Transparent
    )
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            style = OutfitTypography.titleMedium
        )
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFED453A),
                    focusedBorderColor = Color(0xFFED453A),
                    cursorColor = Color(0xFFED453A)
                ),
                textStyle = TextStyle(fontFamily = OutfitFont),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = keyboardType
                ),
                singleLine = singleLine,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}
