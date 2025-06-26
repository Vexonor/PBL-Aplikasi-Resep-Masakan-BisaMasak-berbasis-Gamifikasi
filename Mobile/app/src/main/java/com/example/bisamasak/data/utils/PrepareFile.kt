package com.example.bisamasak.data.utils

import android.content.Context
import android.net.Uri
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okio.BufferedSink
import okio.source
import java.io.File
import java.io.IOException

fun prepareFilePart(
    name: String,
    uri: Uri, context: Context,
    onProgress: ((Float) -> Unit) ? = null
): MultipartBody.Part {

    val mimeType = context.contentResolver.getType(uri) ?: "application/octet-stream"
    val fileName = "file_${System.currentTimeMillis()}.${getExtensionFromMimeType(mimeType)}"

    val requestBody = when (uri.scheme) {
        "file" -> {
            val file = File(uri.path!!)
            if (onProgress != null) {
                ProgressRequestBody(file, mimeType, onProgress)
            } else {
                file.asRequestBody(mimeType.toMediaTypeOrNull())
            }
        }
        else -> {
            val inputStream = context.contentResolver.openInputStream(uri)
                ?: throw IOException("Cannot open input stream for URI: $uri")
            object : RequestBody() {
                override fun contentType() = mimeType.toMediaTypeOrNull()
                override fun writeTo(sink: BufferedSink) {
                    inputStream.source().use { source -> sink.writeAll(source) }
                }
            }
        }
    }

    return MultipartBody.Part.createFormData(name, fileName, requestBody)
}

private fun getExtensionFromMimeType(mimeType: String): String {
    return when (mimeType) {
        "image/jpeg" -> "jpg"
        "image/png" -> "png"
        "image/webp" -> "webp"
        "image/heic" -> "heic"
        "video/mp4" -> "mp4"
        "video/quicktime" -> "mov"
        else -> "bin"
    }
}