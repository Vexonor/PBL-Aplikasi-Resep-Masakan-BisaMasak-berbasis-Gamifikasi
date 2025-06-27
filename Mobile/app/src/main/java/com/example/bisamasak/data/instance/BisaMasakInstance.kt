package com.example.bisamasak.data.instance

import com.example.bisamasak.data.service.BisaMasakService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BisaMasakInstance {
    private val client = OkHttpClient.Builder()
        .connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(120, java.util.concurrent.TimeUnit.SECONDS)
        .writeTimeout(120, java.util.concurrent.TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.100.134:8000/api/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bisaMasakService: BisaMasakService = retrofit.create(BisaMasakService::class.java)
}