package com.example.bisamasak.data.instance

import com.example.bisamasak.data.service.BisaMasakService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BisaMasakInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.100.71:8000/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bisaMasakService: BisaMasakService = retrofit.create(BisaMasakService::class.java)
}