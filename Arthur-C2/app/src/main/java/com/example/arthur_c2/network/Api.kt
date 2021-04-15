package com.example.arthur_c2.network

import com.example.arthur_c2.models.Cachorro
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{id}")
    fun get(@Path("id") id:Int): Call<Cachorro>
}