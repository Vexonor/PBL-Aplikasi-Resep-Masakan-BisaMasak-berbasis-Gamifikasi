package com.example.bisamasak.profile.add_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography

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

data class IngredientInput(
    val namaBahan: String = "",
    val jumlah: String = "",
    val satuan: String = ""
)