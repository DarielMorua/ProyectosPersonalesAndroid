package com.dariel.relaxulsa.gym.network

import com.dariel.relaxulsa.gym.models.Gym
import retrofit2.http.GET


interface GymService {
    @GET("DarielMorua/b8744e1aadfb10aa5d4a780be42ca4cd/raw/6bf6d09b36b96e8f669630d11a7d0e10aec261c3/restaurants.json")
    suspend fun getGyms(): List<Gym>

}