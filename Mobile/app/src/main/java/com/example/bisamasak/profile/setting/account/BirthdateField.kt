package com.example.bisamasak.profile.setting.account

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdateField(
    birthdate: String,
    onBirthdateClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Text(
        text = "Tanggal Lahir",
        style = OutfitTypography.titleMedium,
        color = Color.Black,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
    )
    OutlinedTextField(
        value = birthdate,
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        readOnly = true,
        interactionSource = interactionSource,
        textStyle = OutfitTypography.titleMedium,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xFFED453A),
            focusedBorderColor = Color(0xFFED453A)
        ),
        singleLine = true,
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.CalendarToday,
                contentDescription = null,
                modifier = Modifier.clickable { onBirthdateClick() },
                tint = Color(0xFFED453A)
            )
        }
    )

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            if (interaction is androidx.compose.foundation.interaction.PressInteraction.Release) {
                onBirthdateClick()
            }
        }
    }
}

