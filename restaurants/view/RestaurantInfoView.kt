package com.dariel.relaxulsa.restaurants.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.dariel.relaxulsa.restaurants.models.Restaurant
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng


@Composable
fun RestaurantInfoView(navController: NavHostController, restaurant: Restaurant) {
    Column(modifier = Modifier.padding(16.dp) .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Text(
            text = restaurant.name,
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        )
        AsyncImage(
            model = restaurant.imgName,
            contentDescription = "Restaurant Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )


        ClickablePhoneText(context = LocalContext.current, phoneNumber = restaurant.phone)
        ClickableWebsiteText(context = LocalContext.current, websiteUrl = restaurant.webSite)

        MapViewContainer(latitude = restaurant.latitude.toDouble(), longitude = restaurant.longitude.toDouble())

    }
}

@Composable
fun ClickablePhoneText(context: Context, phoneNumber: String) {
    val phoneStyle = SpanStyle(textDecoration = TextDecoration.Underline)

    val annotatedText = buildAnnotatedString {
        append("Llamar")
        addStyle(
            style = phoneStyle,
            start = 0,
            end = phoneNumber.length
        )
    }

    SelectionContainer {
        ClickableText(
            text = annotatedText,
            onClick = {
                val phoneNumberUri = "tel:$phoneNumber"
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse(phoneNumberUri)
                context.startActivity(intent)
            }, style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                color = androidx.compose.ui.graphics.Color.Blue,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}
@Composable
fun MapViewContainer(latitude: Double, longitude: Double) {
    val context = LocalContext.current as ComponentActivity
    val mapView = rememberMapViewWithLifecycle()

    AndroidView(
        factory = { context ->
            mapView.apply {
                onCreate(null)
                getMapAsync { map ->
                    val location = LatLng(latitude, longitude)
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
@Composable
fun ClickableWebsiteText(context: Context, websiteUrl: String) {
    val webStyle = SpanStyle(textDecoration = TextDecoration.Underline)

    val annotatedText = buildAnnotatedString {
        append("Página Web")
        addStyle(
            style = webStyle,
            start = 0,
            end = length
        )
    }

    // Muestra el texto con la URL como enlace cliclable
    SelectionContainer {
        ClickableText(
            text = annotatedText,
            onClick = {
                // Si se hace clic en el texto, abre la  web en un navegador
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))
                context.startActivity(intent)
            },  style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                color = androidx.compose.ui.graphics.Color.Blue,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    return remember {
        MapView(context).apply {
            id = ViewCompat.generateViewId()
        }
    }
}