@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.dariel.relaxulsa.pantalla

import LottieAnimationView
import ManzanasViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dariel.relaxulsa.R
import com.dariel.relaxulsa.agua.AguaViewModel
import com.dariel.relaxulsa.agua.aguaView
import com.dariel.relaxulsa.calculadora.SumViewModel
import com.dariel.relaxulsa.calculadora.calculadoraView
import com.dariel.relaxulsa.gym.view.gymView
import com.dariel.relaxulsa.gym.viewmodel.GymViewModel
import com.dariel.relaxulsa.imc.IMCViewModel
import com.dariel.relaxulsa.imc.imcView
import com.dariel.relaxulsa.juego.TimeFighterView
import com.dariel.relaxulsa.juego.TimeFighterViewModel
import com.dariel.relaxulsa.manzanas.ManzanasView
import com.dariel.relaxulsa.piedrapapeltijer.PptViewModel
import com.dariel.relaxulsa.piedrapapeltijer.piedraPapelTijeraView
import com.dariel.relaxulsa.restaurants.view.restaurantView
import com.dariel.relaxulsa.restaurants.viewmodel.RestaurantViewModel
import com.dariel.relaxulsa.soccer.SoccerScoreViewModel
import com.dariel.relaxulsa.soccer.soccerView
import com.dariel.relaxulsa.spotify.SpotifyView

@Composable
fun MyAppNavigationView() {
    val navContoller = rememberNavController()
    NavHost(navController = navContoller, startDestination = routes.firstPartialView, builder =  {

        composable(routes.MyAppNavigationView) {
            MyAppNavigationView()
        }
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
        composable(routes.TimeFighterView) {
            TimeFighterView(TimeFighterViewModel(), navContoller)
        }
        composable(routes.SpotifyView){
            SpotifyView(navContoller)
        }
        composable(routes.ManzanasView){
        ManzanasView(ManzanasViewModel(),navContoller)
        }
        composable(routes.LottieAnimationView){
            LottieAnimationView(navContoller)
        }

    })
}

@Composable
fun FirstPartialView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id= R.string.first_partial_title), color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black,
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(text = "First View")
                Button(onClick = {
                    navController.navigate(routes.waterView)
                }) {
                    Text(text = stringResource(id= R.string.goToWater))
                }
                Button(onClick = {
                    navController.navigate(routes.calculadoraView)
                }) {
                    Text(text = stringResource(id= R.string.goToCalculator))
                }
                Button(onClick = {
                    navController.navigate(routes.gymView)
                }) {
                    Text(text =stringResource(id= R.string.goToGym))
                }
                Button(onClick = {
                    navController.navigate(routes.imcView)
                }) {
                    Text(text = stringResource(id= R.string.goToIMC))
                }
                Button(onClick = {
                    navController.navigate(routes.piedraPapelTijeraView)
                }) {
                    Text(text = stringResource(id= R.string.goToRPS))
                }
                Button(onClick = {
                    navController.navigate(routes.restaurantView)
                }) {
                    Text(text = stringResource(id= R.string.goToRestaurant))
                }
                Button(onClick = {
                    navController.navigate(routes.soccerView)
                }) {
                    Text(text = stringResource(id= R.string.goToSoccer))
                }
                Button(onClick = {
                    navController.navigate(routes.TimeFighterView)
                }) {
                    Text(text = stringResource(id= R.string.goToTimeFighter))
                }
                Button(onClick = { navController.navigate(routes.SpotifyView) }) {
                    Text(text = stringResource(id= R.string.goToSpotify))

                }
                Button(onClick = { navController.navigate(routes.ManzanasView) }) {
                    Text(text="Manzanas")

                }
                Button(onClick = { navController.navigate(routes.LottieAnimationView) }) {
                    Text(text="Lottie Animation")

                }
            }
        },
        bottomBar = {
            BottomNavBarView(navController = navController)
        }

        )
}
