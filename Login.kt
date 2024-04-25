package com.dariel.relaxulsa

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dariel.relaxulsa.ui.theme.RelaxUlsaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column {
        TextField(value = username, onValueChange = { username = it },
            placeholder = {
                Text("Email")
            },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(10.dp)

        )
        TextField(value = password, onValueChange = { password = it },
            placeholder = {
                Text("Password")
            },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(10.dp)

        )
        Button(onClick = {  }, modifier = Modifier.fillMaxWidth().padding(30.dp)) {
            Text(text = "Enviar")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
        LoginView()
    }
