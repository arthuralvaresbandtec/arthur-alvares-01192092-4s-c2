package com.example.arthur_c2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Conection {

    fun criar() : Api{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/cachorros/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)

        return api
    }
}