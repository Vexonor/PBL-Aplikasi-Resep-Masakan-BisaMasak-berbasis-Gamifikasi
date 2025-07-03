package com.example.bisamasak.profile.setting.account

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.bisamasak.R
import java.io.File
import java.io.InputStream
import java.io.OutputStream

@Composable
fun AvatarPicker(
    initialPhoto: String,
    onImageFileChanged: (File?) -> Unit
) {
    val context = LocalContext.current

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var file by remember { mutableStateOf<File?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
        uri?.let {
            val inputStream: InputStream? = context.contentResolver.openInputStream(it)
            val tempFile = File(context.cacheDir, "profile_${System.currentTimeMillis()}.jpg")
            val outputStream: OutputStream = tempFile.outputStream()
            inputStream?.copyTo(outputStream)
            inputStream?.close()
            outputStream.close()
            file = tempFile
            onImageFileChanged(tempFile)
        }
    }

    Box(
        modifier = Modifier
            .size(100.dp),
        contentAlignment = Alignment.Center
    ) {
        val imageModifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .clickable { launcher.launch("image/*") }
        when {
            imageUri != null -> {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = "Foto Profil",
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
            }
            initialPhoto.isNotEmpty() -> {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(initialPhoto)
                        .addHeader("User-Agent", "Mozilla/5.0")
                        .crossfade(true)
                        .build(),
                    contentDescription = "Foto Profil",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.img_male_chef),
                    error = painterResource(id = R.drawable.img_male_chef),
                    modifier = imageModifier,
                    onError = { println("COIL ERROR: ${it.result.throwable}") }
                )
            }
            else -> {
                Image(
                    painter = painterResource(id = R.drawable.img_male_chef),
                    contentDescription = "Foto Profil",
                    modifier = imageModifier
                )
            }
        }

        Box(
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.BottomEnd)
                .clip(CircleShape)
                .background(Color.White)
                .border(2.dp, Color(0xFFED453A), CircleShape)
                .clickable { launcher.launch("image/*") },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.CameraAlt,
                contentDescription = "Edit Foto",
                tint = Color(0xFFED453A),
                modifier = Modifier.size(18.dp)
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Edit Foto",
        color = Color.Black
    )
}
