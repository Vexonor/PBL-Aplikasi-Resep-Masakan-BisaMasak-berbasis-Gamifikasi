package com.example.bisamasak.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun CustomTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onVisibilityChange: () -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = OutfitTypography.labelLarge,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(fontFamily = OutfitFont),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = onVisibilityChange) {
                        Icon(
                            painter = painterResource(
                                id = if (passwordVisible) R.drawable.ic_password_on else R.drawable.ic_password_off
                            ),
                            contentDescription = if (passwordVisible) "Sembunyikan Kata Sandi" else "Lihat Kata Sandi"
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Red,
                focusedBorderColor = Color.Red
            ),
            singleLine = true,
            maxLines = 1
        )
    }
}
