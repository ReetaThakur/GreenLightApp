package com.example.greenlightapp.response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    val BASE_URL="https://run.mocky.io/"

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
}