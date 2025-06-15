package com.example.bisamasak.menu.menu_detail

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bisamasak.data.viewModel.ReportViewModel
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun ReportDialog(
    onDismiss: () -> Unit,
    recipeId: Int,
    reportViewModel: ReportViewModel
) {

    val context = LocalContext.current
    var reportText by remember { mutableStateOf("") }

    val isReporting = reportViewModel.isLoading
    val reportSuccess = reportViewModel.isSuccess
    val reportError = reportViewModel.errorMessage

    LaunchedEffect(reportSuccess, reportError) {
        if (reportSuccess) {
            Toast.makeText(context, "Laporan berhasil dikirim", Toast.LENGTH_SHORT).show()
            reportViewModel.resetStatus()
            reportText = ""
            onDismiss()
        }

        reportError?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            reportViewModel.resetStatus()
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
        title = {
            Text(
                text = "Laporkan Konten",
                style = OutfitTypography.titleLarge
            )
        },
        text = {
            Column(
                modifier = Modifier.heightIn(max = 200.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "Mohon hanya untuk melaporkan konten yang mengandung iklan, ujaran kebencian atau konten lain yang tidak berhubungan dengan memasak. Tim BisaMasak akan segera menindak-lajuti laporan ini.",
                    style = OutfitTypography.bodyMedium
                )

                OutlinedTextField(
                    value = reportText,
                    onValueChange = { reportText = it },
                    placeholder = {
                        Text(
                            text = "Tuliskan laporan Anda di sini...",
                            style = OutfitTypography.bodyMedium
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    singleLine = false,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFED453A),
                        unfocusedBorderColor = Color(0xFFED453A),
                        disabledBorderColor = Color.Gray,
                        errorBorderColor = Color.Red
                    ),
                    shape = RoundedCornerShape(12.dp),
                    textStyle = OutfitTypography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (reportText.isNotBlank()) {
                        reportViewModel.createReport(recipeId, reportText)
                    }
                }
            ) {
                if (isReporting) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(
                        text = "Kirim Laporan",
                        style = OutfitTypography.labelLarge,
                        color = Color(0xFFED453A)
                    )
                }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = "Batal",
                    style = OutfitTypography.labelLarge,
                    color = Color.Black
                )
            }
        }
    )
}