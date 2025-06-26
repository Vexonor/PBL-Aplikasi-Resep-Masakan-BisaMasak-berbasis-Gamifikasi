package com.example.bisamasak.profile.add_content

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bisamasak.data.utils.DataStoreManager
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun AddContentScreen(navController: NavController, viewModel: RecipeContentViewModel) {
    val context = LocalContext.current
    val dataStoreManager = remember { DataStoreManager(context) }

    LaunchedEffect(Unit) {
        viewModel.loadIngredient()
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 24.dp, top = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        navController.navigate("profile_screen")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp),
                    elevation = null
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFFED453A),
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Buat Resep",
                    style = OutfitTypography.titleLarge
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Transparent,
                contentColor = Color(0xFFED453A),
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                        navController.navigate("profile_screen?tab=recipe") {
                            popUpTo("add_content_screen") { inclusive = true }
                        }
                        Handler(Looper.getMainLooper()).postDelayed({
                            viewModel.storeRecipeContent(context, dataStoreManager)
                        }, 500)
                        },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFED453A),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent
                    ),
                ) {
                    if (viewModel.isLoading) {
                        androidx.compose.material3.CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier
                                .size(20.dp)
                        )
                    } else {
                        Text(
                            text = "Simpan",
                            style = OutfitTypography.labelLarge
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    ImagePickerScreen(viewModel = viewModel)
                }
                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Judul Konten",
                            style = OutfitTypography.labelLarge,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        OutlinedTextField(
                            value = viewModel.addRecipeState.judul,
                            onValueChange = { viewModel.addRecipeState = viewModel.addRecipeState.copy(judul = it) },
                            placeholder = {
                                Text(
                                    text = "Masukkan judul konten...",
                                    style = OutfitTypography.bodyMedium
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp),
                            textStyle = TextStyle(fontFamily = OutfitFont),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Red,
                                focusedBorderColor = Color.Red
                            ),
                            singleLine = true,
                            maxLines = 1
                        )
                    }
                }
                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Deskripsi Konten",
                            style = OutfitTypography.labelLarge,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        OutlinedTextField(
                            value = viewModel.addRecipeState.deskripsi,
                            onValueChange = { viewModel.addRecipeState = viewModel.addRecipeState.copy(deskripsi = it) },
                            placeholder = {
                                Text(
                                    text = "Masukkan deskripsi konten...",
                                    style = OutfitTypography.bodyMedium
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp),
                            textStyle = TextStyle(fontFamily = OutfitFont),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Red,
                                focusedBorderColor = Color.Red
                            ),
                            singleLine = false
                        )
                    }
                }
                item {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Kategori Masakan",
                            style = OutfitTypography.labelLarge,
                            modifier = Modifier.padding(horizontal = 16.dp),
                        )
                        CategoryDropdown(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            selectedCategory = viewModel.addRecipeState.kategori,
                            onCategorySelected = { viewModel.addRecipeState = viewModel.addRecipeState.copy(kategori = it) }
                        )
                    }
                }
                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Durasi Memasak",
                            style = OutfitTypography.labelLarge,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        OutlinedTextField(
                            value = viewModel.addRecipeState.durasi,
                            onValueChange = { viewModel.addRecipeState = viewModel.addRecipeState.copy(durasi = it) },
                            placeholder = {
                                Text(
                                    text = "Masukkan durasi masakan...",
                                    style = OutfitTypography.bodyMedium
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp),
                            textStyle = TextStyle(fontFamily = OutfitFont),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Red,
                                focusedBorderColor = Color.Red
                            ),
                            singleLine = true,
                            maxLines = 1
                        )
                    }
                }
                item {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Bahan-bahan",
                            style = OutfitTypography.titleMedium
                        )
                        InputIngredientList(viewModel)
                    }
                }
                item {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Video Tutorial",
                            style = OutfitTypography.titleMedium
                        )
                        VideoScreen(viewModel)
                    }
                }
                item {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Langkah-langkah",
                            style = OutfitTypography.titleMedium
                        )
                        StepInputList(viewModel)
                    }
                }
            }
        }
    }
}