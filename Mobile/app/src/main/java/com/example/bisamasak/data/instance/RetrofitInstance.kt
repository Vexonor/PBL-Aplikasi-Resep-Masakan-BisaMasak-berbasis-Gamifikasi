package com.example.bisamasak.data.instance

import com.example.bisamasak.data.service.SpoonacularService
import com.example.bisamasak.data.service.WikipediaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.spoonacular.com/"
    private const val ID_WIKIPEDIA_BASE_URL = "https://id.wikipedia.org/api/rest_v1/"
    private const val EN_WIKIPEDIA_BASE_URL = "https://en.wikipedia.org/api/rest_v1/"

    val api: SpoonacularService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpoonacularService::class.java)
    }

    val wikipediaApiId = Retrofit.Builder()
        .baseUrl(ID_WIKIPEDIA_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WikipediaService::class.java)

    val wikipediaApiEn = Retrofit.Builder()
        .baseUrl(EN_WIKIPEDIA_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WikipediaService::class.java)
}