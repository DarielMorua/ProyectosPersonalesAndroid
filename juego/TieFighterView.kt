@file:OptIn(ExperimentalMaterial3Api::class)

package com.dariel.relaxulsa.juego

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.dariel.relaxulsa.pantalla.BottomNavBarView
import com.dariel.relaxulsa.pantalla.routes

@Composable
fun TieFighterView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menu", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black,
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Text(text = "Tie Fighter")
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Tie Fighter")
                }
                Text(text = "Gola")
                Text(text = "Tie Fighter")
            }
        },
        bottomBar = {
            BottomNavBarView(navController = navController)
        }
    )
}
