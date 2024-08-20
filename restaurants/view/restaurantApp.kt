
package com.dariel.relaxulsa.restaurants.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dariel.relaxulsa.restaurants.view.restaurantView
import com.dariel.relaxulsa.restaurants.viewmodel.RestaurantViewModel
import com.dariel.relaxulsa.restaurants.view.RestaurantInfoView

@Composable
fun RestaurantApp() {
    val navController = rememberNavController()
    val viewModel = RestaurantViewModel()

    NavHost(navController = navController, startDestination = "restaurantList") {
        composable("restaurantList") {
            restaurantView(navController = navController, viewModel = viewModel)

        }
        composable("restaurantDetail/{restaurantId}") { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId")
            val restaurant = viewModel.getRestaurantById(restaurantId) // Llama a la función desde el ViewModel
            if (restaurant != null) {
                RestaurantInfoView(navController = navController, restaurant = restaurant)
            }
        }
    }
}
