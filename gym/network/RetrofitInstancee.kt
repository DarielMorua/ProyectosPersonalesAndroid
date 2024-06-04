package com.dariel.relaxulsa.gym.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstancee {
    private const val BASE_URL = "https://gist.githubusercontent.com/"
    val api: GymService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GymService::class.java)
    }
}
