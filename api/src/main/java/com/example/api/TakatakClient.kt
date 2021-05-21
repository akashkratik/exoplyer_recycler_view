package com.example.api

import com.example.api.services.TakatakApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TakatakClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("http://task.takatakapp.xyz/API/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(TakatakApi::class.java)

}