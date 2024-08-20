package com.dariel.relaxulsa.piedrapapeltijer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.dariel.relaxulsa.R

@Composable
fun piedraPapelTijeraView(viewModel: PptViewModel,navController: NavController) {
    val result: Int by viewModel.result.observeAsState(R.drawable.moai)

    Column {
        Image(
            painter = painterResource(id = result),
            contentDescription = "",Modifier.fillMaxWidth()
        )
        Button(onClick = { viewModel.generar() }) {
            Text("Jugar")
        }
    }
}
