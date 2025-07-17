package com.example.bisamasak.profile.setting.account

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onVisibilityChange: () -> Unit
) {
    Text(
        text = "Kata Sandi",
        style = OutfitTypography.titleMedium,
        color = Color.Black,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
    )
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions.Default,
        textStyle = OutfitTypography.titleMedium,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = onVisibilityChange) {
                Icon(
                    painter = painterResource(
                        id = if (passwordVisible)
                            R.drawable.ic_password_on
                        else
                            R.drawable.ic_password_off
                    ),
                    contentDescription = "Toggle Password Visibility"
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xFFED453A),
            focusedBorderColor = Color(0xFFED453A)
        )
    )
}

@Composable
fun ConfirmPasswordField(
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onVisibilityChange: () -> Unit
) {
    Text(
        text = "Konfirmasi Kata Sandi Baru",
        style = OutfitTypography.titleMedium,
        color = Color.Black,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
    )

    OutlinedTextField(
        value = confirmPassword,
        onValueChange = onConfirmPasswordChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions.Default,
        textStyle = OutfitTypography.titleMedium,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = onVisibilityChange) {
                Icon(
                    painter = painterResource(
                        id = if (passwordVisible)
                            R.drawable.ic_password_on
                        else
                            R.drawable.ic_password_off
                    ),
                    contentDescription = "Toggle Password Visibility"
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xFFED453A),
            focusedBorderColor = Color(0xFFED453A)
        )
    )
}

