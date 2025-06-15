package com.example.bisamasak.data.utils

import com.example.bisamasak.data.dataContainer.Langkah
import com.example.bisamasak.data.dataContainer.RecipeContentResponse

val RecipeContentResponse.imageUrl: String
    get() = ImageConstant.BASE_IMAGE_URL + (this.thumbnail ?: "")

val RecipeContentResponse.videoUrl: String
    get() = ImageConstant.BASE_IMAGE_URL + (this.video_tutorial ?: "")

val Langkah.stepImageUrl: String
    get() = ImageConstant.BASE_IMAGE_URL + (this.gambar_langkah ?: "")