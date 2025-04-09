package com.example.bisamasak.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitFont

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

            Image(
                painter = painterResource(id = R.drawable.ic_app_thumbnail),
                contentDescription = "Logo BisaMasak",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(50))
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "BisaMasak",
                fontFamily = OutfitFont,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )

            Text(
                text = "Resep Masakan",
                fontFamily = OutfitFont,
                fontSize = 14.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Halo,",
                fontFamily = OutfitFont,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )

            Text(
                text = "Selamat Datang di BisaMasak!",
                fontFamily = OutfitFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Email",
                fontFamily = OutfitFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = TextStyle(fontFamily = OutfitFont),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Red,
                    focusedBorderColor = Color.Red
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Kata Sandi",
                fontFamily = OutfitFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(fontFamily = OutfitFont),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(
                                id = if (passwordVisible) R.drawable.baseline_visibility_off_24
                                else R.drawable.baseline_visibility_24
                            ),
                            contentDescription = if (passwordVisible) "Sembunyikan Kata Sandi" else "Lihat Kata Sandi"
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Red,
                    focusedBorderColor = Color.Red
                )
            )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "Lupa Kata Sandi?",
                fontFamily = OutfitFont,
                fontSize = 12.sp,
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
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED453A))
            ) {
                Text(
                    text = "Masuk",
                    fontFamily = OutfitFont,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "Belum punya akun? ",
                    fontFamily = OutfitFont,
                    fontSize = 12.sp,
                    color = Color.Black
                )
                Text(
                    text = "Daftar",
                    fontFamily = OutfitFont,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFED453A),
                    modifier = Modifier.clickable {
                        println("Navigasi ke register_screen")
                        navController.navigate("register_screen")
                    }
                )
            }
        }
    }
}

