package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun PortionSection(
    portion: Int,
    portionText: String,
    onPortionTextChange: (String) -> Unit,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    val customTextHandle = TextSelectionColors(
        handleColor = Color(0xFFED453A),
        backgroundColor = Color.Transparent
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Porsi",
            style = OutfitTypography.titleLarge,
            modifier = Modifier.wrapContentWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onDecrease,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "-", style = OutfitTypography.titleLarge)
            }

            CompositionLocalProvider(LocalTextSelectionColors provides customTextHandle) {
                TextField(
                    value = portionText,
                    onValueChange = onPortionTextChange,
                    textStyle = OutfitTypography.titleLarge.copy(textAlign = TextAlign.Center),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color(0xFFED453A),
                    ),
                    modifier = Modifier.width(60.dp)
                )
            }

            Button(
                onClick = onIncrease,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "+", style = OutfitTypography.titleLarge)
            }
        }
    }
}
