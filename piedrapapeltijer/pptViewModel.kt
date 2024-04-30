package com.dariel.relaxulsa.piedrapapeltijer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dariel.relaxulsa.R

class PptViewModel : ViewModel() {
    private val _result = MutableLiveData<Int>()
    val result: LiveData<Int> = _result

    fun generar() {
        val randomNumber = (0..2).random()

        _result.value = when (randomNumber) {
            0 -> R.drawable.moai
            1 -> R.drawable.papel
            else -> R.drawable.tijeras
        }
    }
}