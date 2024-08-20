package com.dariel.relaxulsa.agua

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dariel.relaxulsa.R


@Composable
fun aguaView(viewModel: AguaViewModel, navController: NavController) {
    val totalAgua: Double by viewModel.getResult().observeAsState(0.0)


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Seleccione la cantidad de agua que ha consumido", modifier = Modifier.padding(16.dp).
        align(Alignment.CenterHorizontally))
        Image(
            painter = painterResource(id = R.drawable.unlitro),
            contentDescription = "Un litro",
            modifier = Modifier
                .size(100.dp)
                .clickable(onClick = { viewModel.agregarAgua(Litros(1.0)) })
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Un litro")

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.mediolitro),
            contentDescription = "500 ml",
            modifier = Modifier
                .size(100.dp)
                .clickable(onClick = { viewModel.agregarAgua(Litros(0.5)) })
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "500 ml")

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.doscinco),
            contentDescription = "255 ml",
            modifier = Modifier
                .size(100.dp)
                .clickable(onClick = { viewModel.agregarAgua(Litros(0.255)) })
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "255 ml")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Total de agua consumida: $totalAgua l")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.reiniciar() }) {
            Text("Restablecer")
        }
    }
}