package com.dariel.relaxulsa.calculadora

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



data class Sum(val num1: Int, val num2: Int,val num3: Int)

class SumViewModel : ViewModel() {
    private val result = MutableLiveData(0)
    fun getResult(): LiveData<Int> = result

    fun sumar(sum: Sum) {
        print("intento de sumar")
        Log.i("log", sum.num1.toString())
        Log.i("log", sum.num2.toString())
        Log.i("log", sum.num3.toString())
        result.postValue(sum.num1 + sum.num2+ sum.num3)
    }
}