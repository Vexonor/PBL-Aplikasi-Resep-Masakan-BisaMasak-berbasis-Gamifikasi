package com.example.bisamasak.profile.setting.account

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun GenderDropdownField(
    gender: String,
    onGenderChange: (String) -> Unit
) {
    val genderOptions = listOf("Laki-laki", "Perempuan")
    var expandedGender by remember { mutableStateOf(false) }

    Text(
        text = "Jenis Kelamin",
        style = OutfitTypography.titleMedium,
        color = Color.Black,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable { expandedGender = true }
    ) {
        OutlinedTextField(
            value = gender,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth(),
            readOnly = true,
            enabled = false,
            shape = RoundedCornerShape(8.dp),
            textStyle = OutfitTypography.titleMedium,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Dropdown"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFED453A),
                focusedBorderColor = Color(0xFFED453A),
                disabledBorderColor = Color(0xFFED453A),
                disabledTextColor = Color.Black
            )
        )
        DropdownMenu(
            expanded = expandedGender,
            onDismissRequest = { expandedGender = false },
            containerColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        ) {
            genderOptions.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onGenderChange(option)
                        expandedGender = false
                    }
                )
            }
        }
    }
}

