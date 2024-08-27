package com.dariel.relaxulsa.juego

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimeFighterViewModel : ViewModel() {
    var counter by mutableStateOf(0)
        private set

    var timeLeft by mutableStateOf(10)
        private set
    var isButtonEnable by mutableStateOf(true)
        private set
    private var timerJob: Job? = null


    fun onButtonClicked() {
        counter++
        if (timerJob == null || timeLeft == 0) {
            starTimer()
        }
    }

    private fun starTimer() {
        timerJob?.cancel()
        isButtonEnable = true
        timerJob = viewModelScope.launch {
            while (timeLeft>0){
                delay(1000L)
                timeLeft--
            }
            isButtonEnable = false
            timerJob = null


        }



    }
     fun resetGame() {
        counter = 0
        timeLeft = 10
        timerJob?.cancel()
        timerJob = null
         isButtonEnable=true
    }
}
