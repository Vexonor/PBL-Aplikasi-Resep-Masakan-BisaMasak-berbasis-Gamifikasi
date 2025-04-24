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
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

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
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Halo,",
                style = OutfitTypography.titleLarge,
                modifier = Modifier.align(Alignment.Start)
            )

            val text = buildAnnotatedString {
                append("Selamat Datang di ")
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
                isPassword = false // Not a password field
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

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Lupa Kata Sandi?",
                style = OutfitTypography.labelLarge,
                color = Color(0xFFED453A),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        navController.navigate("forgot_screen")
                    }
            )

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
                onClick = {
                    navController.navigate("home_screen") {
                        popUpTo("login_screen") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED453A))
            ) {
                Text(
                    text = "Masuk",
                    style = OutfitTypography.titleMedium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "Belum punya akun? ",
                    style = OutfitTypography.labelLarge,
                )
                Text(
                    text = "Daftar",
                    style = OutfitTypography.labelLarge,
                    color = Color(0xFFED453A),
                    modifier = Modifier.clickable {
                        navController.navigate("register_screen")
                    }
                )
            }
        }
    }
}
