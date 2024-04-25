package com.dariel.relaxulsa.calculadora

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun Calculadora(viewModel: SumViewModel){
    var value1 by remember{ mutableStateOf("")}
    var value2 by remember{ mutableStateOf("")}
    var value3 by remember{ mutableStateOf("")}
    val result by viewModel.getResult().observeAsState(0)

    Column {
        TextField(value = value1, onValueChange = { value1 = it },label={ Text(text = "Valor1")},
            placeholder = {
                Text("Primer dato")
            },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(10.dp)

        )
        TextField(value = value2, onValueChange = { value2 = it },label={ Text(text = "Valor2")},
            placeholder = {
                Text("Segundo dato")
            },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(10.dp)

        )
        TextField(value = value3, onValueChange = { value3 = it },label={ Text(text = "Valor3")},
            placeholder = {
                Text("Tercer dato")
            },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(10.dp)

        )
        Button(onClick = {viewModel.sumar(Sum(value1.toInt(),value2.toInt(),value3.toInt()))
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)) {
            Text(text = "Calcular")
        }
        Text(text = "El resultado es ${result}")
}
}
