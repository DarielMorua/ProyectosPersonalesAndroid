package com.dariel.relaxulsa.cardgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dariel.relaxulsa.R

@Composable

fun CardGameView(navController: NavController, viewModel: CardGameViewModel) {
    val result: Int by viewModel.result.observeAsState(R.drawable.back)
    
    Box(){
        Column {
            Image(
                painter = painterResource(id = result),
                contentDescription = "", Modifier.fillMaxWidth().size(700.dp),
            )
            Row {
                Button(onClick = { viewModel.rgenerate() }) {
                    Text("Show Card")
                }
                Button(onClick = { viewModel.back() }) {
                    Text("Back")
                }
            }
        }
    }
}
