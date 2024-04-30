package com.dariel.relaxulsa.imc

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dariel.relaxulsa.R
import com.dariel.relaxulsa.calculadora.Sum
import com.dariel.relaxulsa.soccer.SoccerScoreLocalModel


@Composable
fun IMC(viewModel: IMCViewModel){
    var value1 by remember{ mutableStateOf("")}
    var value2 by remember{ mutableStateOf("")}

    val result by viewModel.getResult().observeAsState(0)

    Column {
        Image(
            painter = painterResource(id = R.drawable.imc),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(value = value1, onValueChange = { value1 = it }, placeholder = { Text(text = "Estatura")},
            label = { Text(text = "Estatura") },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(10.dp)

        )
        TextField(value = value2, onValueChange = {  value2= it },label={ Text(text = "Peso")},
            placeholder = {
                "Peso"
            },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(10.dp)

        )
        Button(onClick ={ viewModel.calcular(IMC(value1.toDouble(),value2.toDouble())) }, modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)) {
            Text(text = "Calcular")
        }
        Text(text = "El resultado es ${result}")
    }
}