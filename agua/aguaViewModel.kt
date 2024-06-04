package com.dariel.relaxulsa.agua

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
data class Litros(val valor: Double)


class AguaViewModel : ViewModel() {
    private val total = MutableLiveData(0.0)

    fun getResult() : LiveData<Double> = total
    fun agregarAgua(litros:Litros) {
        //total.value += litros.valor
        total.value = total.value?.plus(litros.valor)
    }

    fun reiniciar() {
        total.value = 0.0
    }


    }

