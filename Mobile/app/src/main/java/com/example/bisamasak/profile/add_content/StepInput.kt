package com.example.bisamasak.profile.add_content

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun NumberInput(number: Int, modifier: Modifier = Modifier) {
    val customTextSelectionColors = TextSelectionColors(
        handleColor = Color(0xFFED453A),
        backgroundColor = Color.Transparent
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text("No.", style = OutfitTypography.titleMedium)
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            OutlinedTextField(
                value = number.toString(),
                onValueChange = {},
                readOnly = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFED453A),
                    focusedBorderColor = Color(0xFFED453A),
                    cursorColor = Color(0xFFED453A)
                ),
                textStyle = TextStyle(fontFamily = OutfitFont),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun InputStepItem(
    stepNumber: Int,
    onRemove: () -> Unit,
    showRemoveButton: Boolean
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        imageUri = uri
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.weight(0.5f)) {
                NumberInput(number = stepNumber)
            }
            Box(modifier = Modifier.weight(3f)) {
                TextInput(
                    label = "Deskripsi Langkah",
                    singleLine = true,
                    keyboardType = KeyboardType.Text
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Gambar",
                        style = OutfitTypography.titleMedium
                    )
                    Button(
                        onClick = { imagePickerLauncher.launch("image/*") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED453A),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Pilih", style = OutfitTypography.labelLarge)
                    }
                }
            }
        }

        imageUri?.let { uri ->
            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFED453A),
                        shape = RoundedCornerShape(12.dp)
                    )
            ){
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "Selected Image",
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
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
fun StepInputList() {
    val steps = remember { mutableStateListOf(StepItem(id = 1)) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        steps.forEachIndexed { index, step ->
            InputStepItem(
                stepNumber = index + 1,
                showRemoveButton = steps.size > 1,
                onRemove = {
                    steps.removeAt(index)
                }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    steps.add(StepItem(id = steps.size + 1))
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFED453A),
                    contentColor = Color.White
                )
            ) {
                Text("Tambah Input", style = OutfitTypography.labelLarge)
            }
        }
    }
}


data class StepItem(
    val id: Int,
    val description: String = "",
    val imageUri: Uri? = null
)
