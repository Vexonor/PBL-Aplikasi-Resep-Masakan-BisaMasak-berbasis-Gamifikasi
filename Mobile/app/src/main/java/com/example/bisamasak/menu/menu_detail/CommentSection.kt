package com.example.bisamasak.menu.menu_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bisamasak.data.dataContainer.CommentStore
import com.example.bisamasak.data.viewModel.CommentViewModel
import com.example.bisamasak.ui.theme.OutfitFont
import com.example.bisamasak.ui.theme.OutfitTypography
import java.time.Duration
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentSection(
    recipeId: Int,
    userId: Int,
    userName: String,
    viewModel: CommentViewModel = CommentViewModel()
) {
    val comments by viewModel.comments.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var showSheet by remember { mutableStateOf(false) }
    var commentText by remember { mutableStateOf("") }

    LaunchedEffect(recipeId) {
        viewModel.loadCommentsByRecipeId(recipeId)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Komentar",
                style = OutfitTypography.titleLarge,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Text(
                text = "(${comments.size})",
                style = OutfitTypography.titleLarge,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }

        comments.take(2).forEach { comment ->
            CommentPreview(
                userInitial = comment.user_table?.nama?.take(1)?.uppercase() ?: "U",
                userName = comment.user_table?.nama ?: "User",
                commentText = comment.isi_komentar,
                date = formatCommentDate(comment.created_at ?: ""),
                commentUserId = comment.id_user,
                currentUserId = userId,
                onDeleteClick = { viewModel.deleteComment(comment.id_komentar) }
            )
        }

        if (comments.size > 1) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showSheet = true },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Lihat semua komentar",
                    color = Color(0xFFED453A),
                    style = OutfitTypography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }
        }

        CommentInputField(
            commentText = commentText,
            onTextChange = { commentText = it },
            isLoading = isLoading,
            userInitial = userName.take(1).uppercase(),
            onSend = {
                val comment = CommentStore(
                    id_user = userId.toInt(),
                    id_resep = recipeId,
                    isi_komentar = it
                )
                viewModel.storeComment(comment)
                commentText = ""
            }
        )

        if (showSheet) {
            val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

            ModalBottomSheet(
                onDismissRequest = { showSheet = false },
                sheetState = sheetState,
                containerColor = Color.White
            ) {
                val screenHeight = LocalConfiguration.current.screenHeightDp.dp

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenHeight * 0.5f)
                        .padding(24.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Semua Komentar",
                            style = OutfitTypography.titleLarge,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            if (comments.isEmpty()) {
                                Text(
                                    text = "Belum ada komentar.",
                                    style = OutfitTypography.bodyMedium
                                )
                            } else {
                                comments.forEach { comment ->
                                    CommentPreview(
                                        userInitial = comment.user_table?.nama?.take(1)?.uppercase() ?: "U",
                                        userName = comment.user_table?.nama ?: "User",
                                        commentText = comment.isi_komentar,
                                        date = formatCommentDate(comment.created_at ?: ""),
                                        commentUserId = comment.id_user,
                                        currentUserId = userId,
                                        onDeleteClick = { viewModel.deleteComment(comment.id_komentar) }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        CommentInputField(
                            commentText = commentText,
                            onTextChange = { commentText = it },
                            isLoading = isLoading,
                            userInitial = userName.take(1).uppercase(),
                            onSend = {
                                val comment = CommentStore(
                                    id_user = userId.toInt(),
                                    id_resep = recipeId,
                                    isi_komentar = it
                                )
                                viewModel.storeComment(comment)
                                commentText = ""
                            }
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun CommentInputField(
    commentText: String,
    onTextChange: (String) -> Unit,
    isLoading: Boolean,
    onSend: (String) -> Unit,
    userInitial: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar
        Box(
            modifier = Modifier
                .weight(0.4f)
                .size(50.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFFED453A)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = userInitial,
                style = OutfitTypography.displaySmall,
                color = Color.White
            )
        }

        // Text Field
        OutlinedTextField(
            value = commentText,
            onValueChange = onTextChange,
            placeholder = {
                Text(
                    text = "Tuliskan Komentar Anda...",
                    style = OutfitTypography.bodyMedium
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFED453A),
                focusedBorderColor = Color(0xFFED453A),
                cursorColor = Color(0xFFED453A)
            ),
            textStyle = TextStyle(fontFamily = OutfitFont),
            singleLine = false,
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .height(44.dp)
                .padding(horizontal = 12.dp),
        )

        // Send button
        Button(
            modifier = Modifier.weight(0.5f),
            onClick = {
                onSend(commentText)
            },
            enabled = !isLoading && commentText.isNotBlank(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFED453A),
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = "Send",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun CommentPreview(
    userInitial: String,
    userName: String,
    commentText: String,
    date: String,
    commentUserId: Int,
    currentUserId: Int,
    onDeleteClick: () -> Unit
) {
    Row (
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFFED453A)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = userInitial,
                style = OutfitTypography.bodyMedium,
                color = Color.White
            )
        }

        Column (
            modifier = Modifier
                .weight(2f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = userName,
                    style = OutfitTypography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = date,
                    style = OutfitTypography.bodySmall,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
            Text(
                text = commentText,
                style = OutfitTypography.bodyMedium
            )
        }

    var expanded by remember { mutableStateOf(false) }
        if (commentUserId == currentUserId) {
            Box {
                IconButton(
                    onClick = { expanded = true }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Opsi Komentar"
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    containerColor = Color.White
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Hapus",
                                style = OutfitTypography.bodyMedium,
                                color = Color.Red
                            )
                        },
                        onClick = {
                            expanded = false
                            onDeleteClick()
                        }
                    )
                }
            }
        }
    }
}

fun formatCommentDate(createdAt: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
        val commentTime = ZonedDateTime.parse(createdAt, formatter.withZone(ZoneId.of("UTC")))

        val now = ZonedDateTime.now(ZoneId.of("UTC"))
        val duration = Duration.between(commentTime, now)

        when {
            duration.toDays() >= 1 -> "${duration.toDays()} hari yang lalu"
            duration.toHours() >= 1 -> "${duration.toHours()} jam yang lalu"
            duration.toMinutes() >= 1 -> "${duration.toMinutes()} menit yang lalu"
            else -> "Baru saja"
        }
    } catch (e: Exception) {
        createdAt
    }
}

