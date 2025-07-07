package com.example.bisamasak.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bisamasak.R
import com.example.bisamasak.component.BackButton
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.LoginViewModel
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun SettingContent(navController: NavController) {
    val context = LocalContext.current
    val dataStoreManager = remember { DataStoreManager(context) }
    var isNotificationEnabled by remember { mutableStateOf(false) }
    val loginViewModel: LoginViewModel = viewModel()


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
                    text = "Pengaturan Akun",
                    style = OutfitTypography.titleLarge
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notifikasi",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Notifikasi",
                    style = OutfitTypography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Box(modifier = Modifier.scale(0.8f)) {
                    Switch(
                        checked = isNotificationEnabled,
                        onCheckedChange = { isNotificationEnabled = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFFED453A),
                            checkedTrackColor = Color(0x80FF8710)
                        )
                    )
                }
            }

            SettingRow(
                iconRes = R.drawable.ic_account,
                title = "Akun",
                onClick = {
                    navController.navigate("account_screen")
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            SettingRow(
                iconRes = R.drawable.ic_logout,
                title = "Keluar Akun",
                onClick = {
                    loginViewModel.logout(dataStoreManager) {
                        navController.navigate("login_screen") {
                            popUpTo(0)
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun SettingRow(iconRes: Int, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = OutfitTypography.titleMedium,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "Next",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}
