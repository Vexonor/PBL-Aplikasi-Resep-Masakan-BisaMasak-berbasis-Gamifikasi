package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bisamasak.ui.theme.OutfitTypography

@Composable
fun FloatingMenu(
    isDraft: Boolean,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(end = 16.dp, bottom = 16.dp)
    ) {
        FloatingActionButton(
            onClick = { expanded = true },
            containerColor = Color(0xFFED453A),
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Menu"
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = Color.White,
        ) {
            if (isDraft) {
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "Menu"
                        )
                    },
                    text = { Text(
                        text = "Edit",
                        style = OutfitTypography.labelLarge) },
                    onClick = {
                        expanded = false
                        onEditClick()
                    }
                )
            }
            DropdownMenuItem(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Menu"
                    )
                },
                text = { Text(
                    text = "Hapus",
                    style = OutfitTypography.labelLarge) },
                onClick = {
                    expanded = false
                    onDeleteClick()
                }
            )
        }
    }
}
