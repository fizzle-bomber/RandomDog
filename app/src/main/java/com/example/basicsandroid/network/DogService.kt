package com.example.basicsandroid.network

import com.example.basicsandroid.data.Dog
import retrofit2.Response
import retrofit2.http.GET

interface DogService {

    //Base Url: https://dog.ceo/api/breeds/image/random

    @GET("api/breeds/image/random")
    suspend fun getDogImage(): Response<Dog>
}