package com.example.bisamasak.login_register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.component.BackButton
import com.example.bisamasak.component.CustomTextField
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun ForgotScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(onClick = { navController.popBackStack() })
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Lupa Kata Sandi",
                    style = OutfitTypography.titleLarge
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Yah, Kata sandi kamu salah",
                    style = OutfitTypography.titleMedium,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Masukkan emailmu di bawah ini untuk mengulang kata sandi!",
                    style = OutfitTypography.bodyMedium,
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            CustomTextField(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                keyboardType = KeyboardType.Email
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = { navController.navigate("new_password_screen") },
                modifier = Modifier
                    .width(167.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED453A))
            ) {
                Text(
                    text = "Kirim",
                    style = OutfitTypography.titleMedium,
                    color = Color.White
                )
            }
        }
    }
}
