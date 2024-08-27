package com.dariel.relaxulsa.pantalla

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info

val NavBarItems = listOf(
    BarItem(
        title = "Primer Parcial",
        image = Icons.Filled.AccountBox,
        route = routes.MyAppNavigationView
    ),
    BarItem(
        title = "Segundo Parcial",
        image = Icons.Filled.AddCircle,
        route = routes.TimeFighterView
    ),
    BarItem(
        title = "Tercer Parcial",
        image = Icons.Filled.Call,
        route = "cartroute"
    ),
    BarItem(
        title = "6to Semestre",
        image = Icons.Filled.CheckCircle,
        route = "userroute"
    ),
    BarItem(
        title = "5to Semetre",
        image = Icons.Filled.Info,
        route = "userroute"
    ),
)
