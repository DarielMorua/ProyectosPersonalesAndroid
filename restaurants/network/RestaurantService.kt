package com.dariel.relaxulsa.restaurants.network

import com.dariel.relaxulsa.restaurants.models.Restaurant
import retrofit2.http.GET
import retrofit2.http.POST

interface RestaurantService {
    @GET("DarielMorua/b8744e1aadfb10aa5d4a780be42ca4cd/raw/a001d06162076b61e8f67814d4fe975263667725/restaurants.json")
    suspend fun getRestaurants(): List<Restaurant>


}
