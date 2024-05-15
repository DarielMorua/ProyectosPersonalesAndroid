package com.dariel.relaxulsa

import com.dariel.relaxulsa.calculadora.Calculadora
import com.dariel.relaxulsa.calculadora.SumViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dariel.relaxulsa.gym.view.GymView
import com.dariel.relaxulsa.gym.viewmodel.GymViewModel
import com.dariel.relaxulsa.imc.IMC
import com.dariel.relaxulsa.imc.IMCViewModel
import com.dariel.relaxulsa.piedrapapeltijer.PiedraPapelTijera
import com.dariel.relaxulsa.piedrapapeltijer.PptViewModel
import com.dariel.relaxulsa.ui.theme.RelaxUlsaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RelaxUlsaTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
                    //LoginView()
                        // MainScreen(SoccerScoreViewModel())
               // Calculadora( SumViewModel())
                //PiedraPapelTijera( PptViewModel())
                //IMC(IMCViewModel())
                GymView(viewModel = GymViewModel())
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RelaxUlsaTheme {
        Greeting("Android")
    }
}