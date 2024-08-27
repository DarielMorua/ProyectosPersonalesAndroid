@file:OptIn(ExperimentalMaterial3Api::class)

package com.dariel.relaxulsa.juego

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dariel.relaxulsa.R
import com.dariel.relaxulsa.pantalla.BottomNavBarView
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TimeFighterView(viewModel: TimeFighterViewModel, navController: NavController) {
     val context = LocalContext.current
    var buttonSize by remember{ mutableStateOf(100.dp) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    val animatedButtonSize by animateDpAsState(
        targetValue = buttonSize,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    LaunchedEffect(viewModel.counter) {
        if (viewModel.counter == 1) {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(context, R.raw.doom).apply {
                isLooping = true
                start()
            }
        }
    }
    LaunchedEffect(viewModel.timeLeft) {
        if (viewModel.timeLeft == 0) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }
    Scaffold(

        content = {
            Box(modifier = Modifier.fillMaxSize(),        contentAlignment = Alignment.Center) {

                Text(text = "High Score", modifier = Modifier.padding(16.dp).align(Alignment.TopStart))

                Text(text = "Time Left: ${viewModel.timeLeft} ", modifier = Modifier.padding(16.dp).align(Alignment.TopEnd))
                Text(text = "Score: ${viewModel.counter}", modifier = Modifier.padding(16.dp).align(Alignment.TopCenter))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = viewModel.counter.toString())
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            viewModel.onButtonClicked()
                            buttonSize = 120.dp
                        },
                        enabled = viewModel.isButtonEnable,
                        modifier = Modifier.size(animatedButtonSize)
                    ) {
                        Text(text = "Press me")
                    }
                }
            }


            LaunchedEffect(buttonSize) {
                if (buttonSize > 100.dp) {
                    delay(300)
                    buttonSize = 100.dp
                }
            }
        },
        bottomBar = {
            BottomNavBarView(navController = navController)
        }
    )
}
