package com.dariel.relaxulsa

import com.dariel.relaxulsa.calculadora.calculadoraView
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dariel.relaxulsa.pantalla.MyAppNavigationView

import com.dariel.relaxulsa.restaurants.view.RestaurantApp

import com.dariel.relaxulsa.ui.theme.RelaxUlsaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //val navController = rememberNavController()
//MainMenu()
            MyAppNavigationView()
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
