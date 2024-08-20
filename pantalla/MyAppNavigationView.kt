package com.dariel.relaxulsa.pantalla

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dariel.relaxulsa.agua.AguaViewModel
import com.dariel.relaxulsa.agua.aguaView
import com.dariel.relaxulsa.calculadora.SumViewModel
import com.dariel.relaxulsa.calculadora.calculadoraView
import com.dariel.relaxulsa.gym.view.gymView
import com.dariel.relaxulsa.gym.viewmodel.GymViewModel
import com.dariel.relaxulsa.imc.IMCViewModel
import com.dariel.relaxulsa.imc.imcView
import com.dariel.relaxulsa.pantalla.routes.gymView
import com.dariel.relaxulsa.pantalla.routes.restaurantView
import com.dariel.relaxulsa.piedrapapeltijer.PptViewModel
import com.dariel.relaxulsa.piedrapapeltijer.piedraPapelTijeraView
import com.dariel.relaxulsa.restaurants.view.restaurantView
import com.dariel.relaxulsa.restaurants.viewmodel.RestaurantViewModel
import com.dariel.relaxulsa.soccer.SoccerScoreViewModel
import com.dariel.relaxulsa.soccer.soccerView

@Composable
fun MyAppNavigationView() {
    val navContoller = rememberNavController()
    NavHost(navController = navContoller, startDestination = routes.firstPartialView, builder =  {

        composable(routes.firstPartialView) {
            FirstPartialView(navContoller)
        }

        composable(routes.waterView) {
            aguaView(AguaViewModel(),navContoller)
        }
        composable(routes.calculadoraView) {
            calculadoraView(SumViewModel(),navContoller)
        }
        composable(routes.gymView) {
            gymView(GymViewModel(),navContoller)
        }
        composable(routes.imcView) {
            imcView(IMCViewModel(),navContoller)
        }
        composable(routes.piedraPapelTijeraView) {
            piedraPapelTijeraView(PptViewModel(),navContoller)
        }
        composable(routes.restaurantView) {
            restaurantView(RestaurantViewModel(),navContoller)
        }
        composable(routes.soccerView) {
            soccerView(SoccerScoreViewModel(),navContoller)
        }

    })
}

@Composable
fun FirstPartialView(navController: NavController) {
    Column {
        Text(text = "First View")

        Button(onClick = {
            navController.navigate(routes.waterView)
        }) {
            Text(text = "Agua")
        }
        Button(onClick = {
            navController.navigate(routes.calculadoraView)
        }) {
            Text(text = "Calculadora")
        }
        Button(onClick = {
            navController.navigate(routes.gymView)
        }) {
            Text(text = "Gym")
        }
        Button(onClick = {
            navController.navigate(routes.imcView)
        }) {
            Text(text = "IMC")
        }
        Button(onClick = {
            navController.navigate(routes.piedraPapelTijeraView)
        }) {
            Text(text = "Piedra Papel Tijera")
        }
        Button(onClick = {
            navController.navigate(routes.restaurantView)
        }) {
            Text(text = "Restaurant")
        }
        Button(onClick = {
            navController.navigate(routes.soccerView)
        }) {
            Text(text = "Soccer")
        }

    }
}