package com.example.bisamasak.profile.setting.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bisamasak.R
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun AccountContent(navController: NavController) {
    var name by remember { mutableStateOf("Rizqi Vela Syifa") }
    var email by remember { mutableStateOf("velasyifa02@gmail.com") }
    var password by remember { mutableStateOf("password123") }
    var passwordVisible by remember { mutableStateOf(false) }

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
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFFED453A),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.popBackStack() }
                )

                Text(
                    text = "Edit Akun",
                    style = OutfitTypography.headlineSmall,
                    color = Color.Black
                )

                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save",
                    tint = Color(0xFFED453A),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            // TODO: Save logic
                        }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Avatar
            Image(
                painter = painterResource(id = R.drawable.img_male_chef),
                contentDescription = "Edit Foto",
                modifier = Modifier.size(90.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Edit Foto",
                fontFamily = OutfitFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Nama",
                style = OutfitTypography.titleMedium, 
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = OutfitTypography.titleMedium, 
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFED453A),
                    focusedBorderColor = Color(0xFFED453A)
                )
            )

            Text(
                text = "Email",
                style = OutfitTypography.titleMedium, // Menggunakan titleMedium
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = OutfitTypography.titleMedium, // Menggunakan titleMedium
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFED453A),
                    focusedBorderColor = Color(0xFFED453A)
                )
            )

            Text(
                text = "Kata Sandi",
                style = OutfitTypography.titleMedium, // Menggunakan titleMedium
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = OutfitTypography.titleMedium, // Menggunakan titleMedium
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
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
    }
}
