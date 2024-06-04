package com.dariel.relaxulsa.restaurants.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dariel.relaxulsa.restaurants.models.Restaurant
import com.dariel.relaxulsa.restaurants.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantViewModel : ViewModel() {
    private val apiRestaurantService = RetrofitInstance.api
    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants

    private val _selectedRestaurant = MutableStateFlow<Restaurant?>(null)
    val selectedRestaurant: StateFlow<Restaurant?> = _selectedRestaurant

    fun getRestaurants() {
        viewModelScope.launch {
            try {
                val response = apiRestaurantService.getRestaurants()
                Log.d("RestaurantViewModel", "Restaurants: $response")
                if (response.isNotEmpty()) {
                    _restaurants.value = response
                }
            } catch (e: Exception) {
                Log.e(
                    "RestaurantViewModel",
                    e.message ?: "Error al obtener los restaurantes"
                )
            }
        }
    }

    fun selectRestaurant(restaurant: Restaurant) {
        _selectedRestaurant.value = restaurant
    }

    fun getRestaurantById(id: String?): Restaurant? {
        return _restaurants.value.find { it.id == id }
    }
}
