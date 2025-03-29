package com.example.bisamasak.forgot

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bisamasak.ui.theme.OutfitFont

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
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFFED453A),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.popBackStack() }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Lupa Kata Sandi",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = OutfitFont,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Yah, Kata sandi kamu salah",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = OutfitFont,
                    color = Color.Black
                )
                Text(
                    text = "Masukkan emailmu di bawah ini untuk mengulang kata sandi!",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = OutfitFont,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Email",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = OutfitFont,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = TextStyle(fontSize = 14.sp, fontFamily = OutfitFont),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Red,
                    focusedBorderColor = Color.Red
                )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = {
                    navController.navigate("new_password_screen")
                },
                modifier = Modifier
                    .width(167.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED453A))
            ) {
                Text(
                    text = "Kirim",
                    fontFamily = OutfitFont,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}
