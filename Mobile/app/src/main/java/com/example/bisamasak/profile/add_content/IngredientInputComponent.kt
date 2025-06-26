package com.example.bisamasak.profile.add_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bisamasak.data.dataContainer.IngredientResponse
import com.example.bisamasak.data.viewModel.IngredientInput
import com.example.bisamasak.data.viewModel.RecipeContentViewModel
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun InputIngredientItem(
    input: IngredientInput,
    ingredientList: List<IngredientResponse>,
    onInputChange: (IngredientInput) -> Unit,
    onRemove: () -> Unit,
    showRemoveButton: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.weight(2f)) {
                val namaBahanOptions = ingredientList.map { it.nama_bahan }
                ComboBox(
                    label = "Nama Bahan",
                    options = namaBahanOptions,
                    selected = input.namaBahan,
                    onSelectedChange = { selectedName ->
                        val selectedIngredient = ingredientList.find { it.nama_bahan == selectedName }
                        onInputChange(
                            input.copy(
                                namaBahan = selectedName,
                                idBahan = selectedIngredient?.id_bahan
                            )
                        )
                    }
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "Jumlah",
                        style = OutfitTypography.labelLarge,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    OutlinedTextField(
                        value = input.jumlah,
                        onValueChange = { onInputChange(input.copy(jumlah = it)) },
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
            Box(modifier = Modifier.weight(2f)) {
                ComboBox(
                    label = "Satuan",
                    options = listOf(
                        "g", "kg", "ml", "L", "cm", "sdt", "sdm",
                        "cup", "buah", "butir", "siung", "batang",
                        "lembar", "potong", "sejumput", "secukupnya"
                    ),
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
fun InputIngredientList(viewModel: RecipeContentViewModel = viewModel()) {
    val inputList = viewModel.ingredientInputs
    val ingredientList = viewModel.ingredientList

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        inputList.forEachIndexed { index, input ->
            InputIngredientItem(
                input = input,
                ingredientList = ingredientList,
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