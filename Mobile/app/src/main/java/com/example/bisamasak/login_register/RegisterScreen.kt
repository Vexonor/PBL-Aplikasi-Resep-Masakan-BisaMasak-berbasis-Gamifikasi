package com.example.bisamasak.login_register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.ui.theme.OutfitTypography
import com.example.bisamasak.component.CustomTextField
import com.example.bisamasak.component.AppLogo

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPassword by remember { mutableStateOf("") }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(56.dp))

            AppLogo()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "BisaMasak",
                style = OutfitTypography.headlineMedium,
            )

            Text(
                text = "Resep Masakan",
                style = OutfitTypography.bodyMedium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Halo,",
                style = OutfitTypography.titleLarge,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )

            val text = buildAnnotatedString {
                append("Daftar Akunmu di ")
                withStyle(style = SpanStyle(color = Color(0xFFED453A))) {
                    append("BisaMasak!")
                }
            }

            Text(
                text = text,
                style = OutfitTypography.titleMedium,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(32.dp))

            CustomTextField(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                isPassword = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                label = "Kata Sandi",
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                passwordVisible = passwordVisible,
                onVisibilityChange = { passwordVisible = !passwordVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                label = "Konfirmasi Kata Sandi",
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                isPassword = true,
                passwordVisible = confirmPasswordVisible,
                onVisibilityChange = { confirmPasswordVisible = !confirmPasswordVisible }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Spacer(modifier = Modifier.weight(1f))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = { /* TODO: Handle Register */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED453A))
            ) {
                Text(
                    text = "Daftar",
                    style = OutfitTypography.titleLarge,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "Sudah punya akun? ",
                    style = OutfitTypography.labelLarge,
                )
                Text(
                    text = "Masuk",
                    style = OutfitTypography.labelLarge,
                    color = Color(0xFFED453A),
                    modifier = Modifier.clickable {
                        navController.navigate("login_screen")
                    }
                )
            }
        }
    }
}
