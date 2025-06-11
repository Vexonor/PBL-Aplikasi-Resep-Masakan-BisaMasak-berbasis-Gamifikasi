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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bisamasak.ui.theme.OutfitTypography
import com.example.bisamasak.component.CustomTextField
import com.example.bisamasak.component.AppLogo
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.RegisterViewModel
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavController) {

    val viewModel: RegisterViewModel = viewModel()
    val context = LocalContext.current
    val dataStore = remember { DataStoreManager(context) }
    val coroutineScope = rememberCoroutineScope()

    var email by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPassword by remember { mutableStateOf("") }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    LaunchedEffect(viewModel.isRegisterSuccess) {
        if (viewModel.isRegisterSuccess) {
            coroutineScope.launch {
                dataStore.setUserName(viewModel.registerUserName)
                dataStore.setLogin(true)
            }
            navController.navigate("login_screen") {
                popUpTo("register_screen") { inclusive = true }
            }
        }
    }

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
                label = "Nama",
                value = nama,
                onValueChange = { nama = it },
                isPassword = false
            )

            Spacer(modifier = Modifier.height(16.dp))

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

            if (viewModel.responseMessage.isNotEmpty()) {
                Text(
                    text = viewModel.responseMessage,
                    color = if (viewModel.responseMessage.contains("Success")) Color(0xFF4CAF50) else Color.Red,
                    style = OutfitTypography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

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
                    if (password != confirmPassword) {
                        viewModel.responseMessage = "Kata Sandi dan Konfirmasi Kata Sandi Tidak Sama"
                    } else if (nama.isBlank() || email.isBlank() || password.isBlank()) {
                        viewModel.responseMessage = "Nama, Email dan Kata Sandi Tidak Boleh Kosong"
                    } else {
                        viewModel.register(nama, email, password)
                    }
                },
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
