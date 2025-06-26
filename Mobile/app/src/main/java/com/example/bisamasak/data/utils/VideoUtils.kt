package com.example.bisamasak.data.utils

import android.content.Context
import android.net.Uri
import com.arthenica.ffmpegkit.FFmpegKit
import com.arthenica.ffmpegkit.ReturnCode
import java.io.File
import java.io.FileOutputStream

object VideoUtils {

    fun compressVideo(
        context: Context,
        inputUri: Uri,
        onSuccess: (Uri) -> Unit,
        onFailure: (String) -> Unit
    ) {
        try {
            val inputFile = File.createTempFile("input_video", ".mp4", context.cacheDir)
            context.contentResolver.openInputStream(inputUri)?.use { inputStream ->
                FileOutputStream(inputFile).use { output -> inputStream.copyTo(output) }
            }

            val outputFile = File.createTempFile("compressed_video", ".mp4", context.cacheDir)
            val inputPath = inputFile.absolutePath
            val outputPath = outputFile.absolutePath

            val cmd = "-y -i \"$inputPath\" -c:v mpeg4 -q:v 2 -c:a aac -b:a 128k \"$outputPath\""

            FFmpegKit.executeAsync(cmd,
                { session ->
                    val returnCode = session.returnCode
                    if (ReturnCode.isSuccess(returnCode)) {
                        onSuccess(Uri.fromFile(outputFile))
                    } else {
                        val error = session.allLogsAsString
                        onFailure("Compression failed: $error")
                    }
                }
            )

        } catch (e: Exception) {
            onFailure("Exception: ${e.localizedMessage}")
        }
    }
}
