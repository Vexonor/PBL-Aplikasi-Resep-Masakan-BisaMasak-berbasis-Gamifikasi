package com.example.bisamasak.profile.add_content

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun AddContentScreen(navController: NavController) {
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
                    ImagePickerScreen()
                }
                item {
                    TextInput(
                        label = "Judul Konten",
                        singleLine = true,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        keyboardType = KeyboardType.Text
                    )
                }
                item {
                    TextInput(
                        label = "Deskripsi Konten",
                        singleLine = false,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        keyboardType = KeyboardType.Text
                    )
                }
                item {
                    TextInput(
                        label = "Durasi Memasak",
                        singleLine = true,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        keyboardType = KeyboardType.Number
                    )
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
                        InputIngredientList()
                    }
                }
            }
        }
    }
}

@Composable
fun ImagePickerScreen() {
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Gambar Sampul",
            style = OutfitTypography.titleMedium
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { launcher.launch("image/*") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFED453A),
                contentColor = Color.White,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            ),
        ) {
            Text(
                text = "Pilih Gambar",
                style = OutfitTypography.labelLarge
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        imageUri?.let { uri ->
            Image(
                painter = rememberAsyncImagePainter(uri),
                contentDescription = "Selected Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun TextInput(label: String, singleLine: Boolean, keyboardType: KeyboardType, modifier: Modifier = Modifier) {
    val customTextSelectionColors  = TextSelectionColors(
        handleColor = Color(0xFFED453A),
        backgroundColor = Color.Transparent
    )
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            style = OutfitTypography.titleMedium
        )
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFED453A),
                    focusedBorderColor = Color(0xFFED453A),
                    cursorColor = Color(0xFFED453A)
                ),
                textStyle = TextStyle(fontFamily = OutfitFont),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = keyboardType
                ),
                singleLine = singleLine,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun InputIngredientItem(
    input: IngredientInput,
    onInputChange: (IngredientInput) -> Unit,
    onRemove: () -> Unit,
    showRemoveButton: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.weight(2f)) {
                ComboBox(
                    label = "Nama Bahan",
                    options = listOf("Makanan", "Minuman", "Lainnya"),
                    selected = input.namaBahan,
                    onSelectedChange = { onInputChange(input.copy(namaBahan = it)) }
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                TextInput(
                    label = "Jumlah",
                    singleLine = true,
                    keyboardType = KeyboardType.Number
                )
            }
            Box(modifier = Modifier.weight(2f)) {
                ComboBox(
                    label = "Satuan",
                    options = listOf("Potong", "Buah", "g"),
                    selected = input.satuan,
                    onSelectedChange = { onInputChange(input.copy(satuan = it)) }
                )
            }
        }

        if (showRemoveButton) {
            Button(
                onClick = onRemove,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFED453A),
                    contentColor = Color.White
                )
            ) {
                Text("Hapus Input", style = OutfitTypography.labelLarge)
            }
        }
    }
}

@Composable
fun InputIngredientList() {
    val inputList = remember { mutableStateListOf(IngredientInput()) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        inputList.forEachIndexed { index, input ->
            InputIngredientItem(
                input = input,
                onInputChange = { updated ->
                    inputList[index] = updated
                },
                onRemove = {
                    if (inputList.size > 1) {
                        inputList.removeAt(index)
                    }
                },
                showRemoveButton = inputList.size > 1
            )
        }

        Button(
            onClick = {
                inputList.add(IngredientInput())
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFED453A),
                contentColor = Color.White
            )
        ) {
            Text("Tambah Input", style = OutfitTypography.labelLarge)
        }
    }
}

@Composable
fun ComboBox(
    label: String,
    options: List<String>,
    selected: String,
    onSelectedChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val filteredOptions = options.filter { it.contains(selected, ignoreCase = true) }

    Box(modifier = modifier.fillMaxWidth()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = label,
                style = OutfitTypography.titleMedium
            )
            OutlinedTextField(
                value = selected,
                onValueChange = {
                    onSelectedChange(it)
                    expanded = true
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                },
                textStyle = TextStyle(fontFamily = OutfitFont),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFED453A),
                    focusedBorderColor = Color(0xFFED453A),
                    cursorColor = Color(0xFFED453A)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        expanded = it.isFocused
                    }
            )
            DropdownMenu(
                expanded = expanded && filteredOptions.isNotEmpty(),
                onDismissRequest = { expanded = false },
                containerColor = Color(0xFFFAFAFA),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            ) {
                filteredOptions.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = option,
                                style = OutfitTypography.labelLarge
                            )
                        },
                        onClick = {
                            onSelectedChange(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

data class IngredientInput(
    val namaBahan: String = "",
    val jumlah: String = "",
    val satuan: String = ""
)