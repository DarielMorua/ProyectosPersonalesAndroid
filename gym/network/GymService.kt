package com.dariel.relaxulsa.gym.network

import com.dariel.relaxulsa.gym.models.Gym
import retrofit2.http.GET


interface GymService {
    @GET("DarielMorua/2292d7b95d33fe23734a21485728037a/raw/87a861a04f3fe5e0ed6283bfffd5797e866d46be/gyms.json")
    suspend fun getGyms(): List<Gym>

}