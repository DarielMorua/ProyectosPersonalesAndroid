package com.dariel.relaxulsa.restaurants.view

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.dariel.relaxulsa.restaurants.viewmodel.RestaurantViewModel

@Composable
fun RestaurantView(viewModel: RestaurantViewModel, navController: NavHostController) {
    val restaurants by viewModel.restaurants.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(restaurants) { restaurant ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = restaurant.name,
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp,
                            lineHeight = 24.sp,
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = restaurant.rating.toString(),
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp,
                            lineHeight = 24.sp,
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.padding(end = 8.dp).background(androidx.compose.ui.graphics.Color.Gray)
                    )
                }
            }





            Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                ) {
                    AsyncImage(
                        model = restaurant.imgName,
                        contentDescription = "Restaurant Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clickable(onClick = {
                                navController.navigate("restaurantDetail/${restaurant.id}")
                            })
                    )

                    Icon(
                        imageVector = if (restaurant.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = androidx.compose.ui.graphics.Color.Red,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp)
                            .clickable(onClick = { })


                ) }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "moni",

                    )
                    Text(
                        text = "MX "+restaurant.fee+" Delivery Fee • ", style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            letterSpacing = 0.5.sp,
                            lineHeight = 24.sp,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = restaurant.delivery,
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            letterSpacing = 0.5.sp,
                            lineHeight = 24.sp,
                            fontSize = 18.sp
                        )
                    )
                }
            }



            }
        }


    DisposableEffect(Unit) {
        viewModel.getRestaurants()
        onDispose { }
    }
}
