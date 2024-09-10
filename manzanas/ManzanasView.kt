package com.dariel.relaxulsa.manzanas

import Manzanas
import ManzanasViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.dariel.relaxulsa.R

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun ManzanasView(viewModel: ManzanasViewModel = viewModel(), navController: NavController) {
    val context = LocalContext.current // Obtener el contexto
    val produccionTotal by viewModel.produccionTotal.observeAsState(0)
    val produccionActual by viewModel.produccionActual.observeAsState(0)
    val result by viewModel.result.observeAsState(0.0)
    var backgroundColor by remember { mutableStateOf(Color.White) }

    Box(modifier = Modifier.padding(16.dp).background(backgroundColor).fillMaxSize()) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.manzana),
                contentDescription = "Manzanas",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total:",
                    modifier = Modifier.padding(end = 8.dp),
                    style = TextStyle(color = Color.Black)
                )
                TextField(
                    value = produccionTotal.toString(),
                    onValueChange = { value ->
                        val intValue = value.toIntOrNull() ?: 0
                        viewModel.setProduccionTotal(intValue)
                    },
                    placeholder = { Text(text = "Producción Total") },
                    label = { Text(text = "Producción Total") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    textStyle = TextStyle(color = Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    shape = RoundedCornerShape(10.dp)
                )

                Button(
                    onClick = {
                        Toast.makeText(context, "Total: ${produccionTotal * 80}", Toast.LENGTH_LONG).show()
                    },
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(64.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "Clear",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Actual:",
                    modifier = Modifier.padding(end = 8.dp),
                    style = TextStyle(color = Color.Black)
                )
                TextField(
                    value = produccionActual.toString(),
                    onValueChange = { value ->
                        val intValue = value.toIntOrNull() ?: 0
                        viewModel.setProduccionActual(intValue)
                    },
                    label = { Text(text = "Producción Actual") },
                    placeholder = { Text(text = "Producción Actual") },
                    textStyle = TextStyle(color = Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    shape = RoundedCornerShape(10.dp)
                )
                Button(
                    onClick = {
                        Toast.makeText(context, "Total: ${produccionActual * 80}", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(64.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "Clear",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Button(
                    onClick = { viewModel.incrementar(5) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                        .size(40.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "+5")
                }

                Button(
                    onClick = { viewModel.incrementar(15) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                        .size(40.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "+15")
                }

                Button(
                    onClick = { viewModel.incrementar(30) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                        .size(40.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "+30")
                }

                Button(
                    onClick = { viewModel.incrementar(50) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                        .size(40.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "+50")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Resultado:",
                    modifier = Modifier.padding(end = 8.dp),
                    style = TextStyle(color = Color.Black)
                )
                TextField(
                    value = result.toString(),
                    onValueChange = {},
                    enabled = false,
                    textStyle = TextStyle(color = Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    shape = RoundedCornerShape(10.dp)
                )
            }

            Button(
                onClick = {
                    val pt = produccionTotal
                    val pa = produccionActual
                    viewModel.calcular(Manzanas(pt, pa))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(text = "Calcular")
            }
        }
    }

    LaunchedEffect(result) {
        backgroundColor = if (result >= 70) Color.Red else Color.White
    }
}
