package com.dariel.relaxulsa.gym.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dariel.relaxulsa.gym.models.Gym
import com.dariel.relaxulsa.gym.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GymViewModel : ViewModel() {
    private val ApiGymService = RetrofitInstance.api
    val gyms = MutableStateFlow<List<Gym>>(emptyList())

    fun getGyms() {
        viewModelScope.launch {
            try {
                val response = ApiGymService.getGyms()
                Log.d("GymViewModel", "Gyms: $response")
                if (response.isNotEmpty()) {
                    gyms.value = response
                }
            } catch (e: Exception) {
                Log.e(
                    "GymViewModel",
                    e.message ?: "Error al obtener los gimnasios"
                )
            }
        }
    }
}
