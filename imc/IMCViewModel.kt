package com.dariel.relaxulsa.imc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class IMC(val estatura: Double, val peso: Double)

class IMCViewModel : ViewModel() {
    private val result = MutableLiveData(0.0)
    fun getResult(): LiveData<Double> = result

    fun calcular(imc: IMC) {
        print("intento de sumar")
        Log.i("log", imc.estatura.toString())
        Log.i("log", imc.peso.toString())
        result.postValue(imc.peso / (imc.estatura * imc.estatura))
    }
}