package com.dariel.relaxulsa.spotify

import ExoPlayerExample
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.dariel.relaxulsa.R

@SuppressLint("ResourceType")
@Composable
fun SpotifyView(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        ExoPlayerExample(
            modifier = Modifier
                .fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.raw.spo),
            contentDescription = "Imagen encima del video",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(250.dp)
                .zIndex(1f)
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = "Login")
            }

            Button(
                onClick = {  },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = "SignUp")
            }
        }
    }
}
