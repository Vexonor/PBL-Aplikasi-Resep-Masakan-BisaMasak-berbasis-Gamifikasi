package com.example.bisamasak.profile.setting.account

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.utils.photoUrl
import com.example.bisamasak.data.viewModel.ProfileViewModel
import com.example.bisamasak.ui.theme.OutfitTypography
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountContent(navController: NavController, dataStoreManager: DataStoreManager) {
    val profileViewModel = remember { ProfileViewModel(dataStoreManager) }
    val isLoading by profileViewModel.isLoading
    val responseMessage by profileViewModel.responseMessage
    val isSuccess by profileViewModel.isSuccess
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var birthdate by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    var gender by remember { mutableStateOf("") }
    var photo by remember { mutableStateOf("") }
    var idUser by remember { mutableLongStateOf(-1L) }
    var photoFile by remember { mutableStateOf<File?>(null) }

    LaunchedEffect(Unit) {
        idUser = dataStoreManager.getUserId()
        val user = dataStoreManager.getUser()
        user?.let {
            name = it.nama
            email = it.email
            birthdate = it.tanggalLahir ?: ""
            gender = it.jenisKelamin ?: ""
            photo = it.photoUrl
        }
    }

    LaunchedEffect(responseMessage) {
        if (responseMessage.isNotEmpty()) {
            val text = if (isSuccess) {
                responseMessage
            } else {
                responseMessage
            }
            Toast.makeText(
                context,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                ),
                title = {
                    Text(
                        text = "Edit Akun",
                        style = OutfitTypography.headlineSmall,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFFED453A)
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            profileViewModel.updateProfile(
                                idUser = idUser,
                                nama = name,
                                email = email,
                                tanggalLahir = if (birthdate.isNotEmpty()) birthdate else null,
                                jenisKelamin = if (gender.isNotEmpty()) gender else null,
                                password = if (password.isNotEmpty()) password else null,
                                photoFile = photoFile
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Save",
                            tint = Color(0xFFED453A)
                        )
                    }
                }
            )
        },
        containerColor = Color.White
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                // Avatar
                AvatarPicker(
                    initialPhoto = photo,
                    onImageFileChanged = { file -> photoFile = file }
                )
                Spacer(modifier = Modifier.height(24.dp))

                NameField(name, onNameChange = { name = it })
                EmailField(email, onEmailChange = { email = it })
                PasswordField(password, onPasswordChange = { password = it }, passwordVisible, { passwordVisible = !passwordVisible })
                BirthdateField(birthdate, onBirthdateClick = { showDatePicker = true })
                if (showDatePicker) {
                    val datePickerState = rememberDatePickerState()
                    DatePickerDialog(
                        onDismissRequest = { showDatePicker = false },
                        colors = DatePickerDefaults.colors(
                            containerColor = Color.White,
                            titleContentColor = Color.Black,
                            headlineContentColor = Color.Black,
                            weekdayContentColor = Color.Black,
                            subheadContentColor = Color.Black,
                            currentYearContentColor = Color(0xFFED453A),
                            selectedDayContainerColor = Color(0xFFED453A),
                            selectedDayContentColor = Color.White,
                            todayDateBorderColor = Color(0xFFED453A),
                            todayContentColor = Color(0xFFED453A),
                            dayContentColor = Color.Black,
                            dayInSelectionRangeContainerColor = Color.White
                        ),
                        confirmButton = {
                            TextButton(onClick = { showDatePicker = false }) { Text("OK") }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDatePicker = false }) { Text("Cancel") }
                        }
                    ) {
                        DatePicker(state = datePickerState)
                        LaunchedEffect(datePickerState.selectedDateMillis) {
                            datePickerState.selectedDateMillis?.let { millis ->
                                val formatter = SimpleDateFormat("yyyy-MM-dd")
                                birthdate = formatter.format(Date(millis))
                            }
                        }
                    }
                }
                GenderDropdownField(gender, onGenderChange = { gender = it })
            }

            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xAAFFFFFF)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = Color(0xFFED453A)
                    )
                }
            }
        }
    }
}
