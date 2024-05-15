package com.dariel.relaxulsa.gym.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.dariel.relaxulsa.gym.viewmodel.GymViewModel
import coil.compose.AsyncImage

@Composable
fun GymView(viewModel: GymViewModel) {
    val gyms by viewModel.gyms.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(gyms) { gym ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = gym.name,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    AsyncImage(
                        model = gym.imageURL,
                        contentDescription = "Gym Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                    Text(
                        text = gym.latitude,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }

    DisposableEffect(Unit) {
        viewModel.getGyms()
        onDispose { }
    }
}