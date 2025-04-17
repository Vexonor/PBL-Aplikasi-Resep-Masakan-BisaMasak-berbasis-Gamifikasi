package com.example.bisamasak.data.service

import com.example.bisamasak.data.response.WikipediaResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WikipediaService {
    @GET("page/summary/{title}")
    suspend fun getSummary(
        @Path("title") title: String
    ): WikipediaResponse
}