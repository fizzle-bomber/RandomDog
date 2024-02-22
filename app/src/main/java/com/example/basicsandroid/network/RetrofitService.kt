package com.example.basicsandroid.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val API_URL = "https://dog.ceo/"

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val dogService: DogService by lazy {
        provideRetrofit().create(DogService::class.java)
    }

}