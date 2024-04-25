package com.dariel.relaxulsa.soccer
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dariel.relaxulsa.R

@Composable
fun MainScreen(viewModel: SoccerScoreViewModel) {
    val localScoreResult by viewModel.getLocalScore().observeAsState(0)
    val visitScoreResult by viewModel.getVisitScore().observeAsState(0)


    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Marcador Oficial", fontSize = 50.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                modifier = Modifier.width(100.dp).clickable {
                    Log.d("sumarr", "local")
                    viewModel.incrementLocalScore(SoccerScoreLocalModel(localScoreResult))
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "$localScoreResult",
                fontSize = 50.sp,
                modifier = Modifier.padding(bottom = 8.dp).background(Color.White)
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = "$visitScoreResult", fontSize = 50.sp,
                modifier = Modifier.padding(bottom = 8.dp).background(Color.White)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.i),
                contentDescription = null,
                modifier = Modifier.width(100.dp).clickable {
                    print("sumar")
                    Log.d("sumarr", "visitante")
                    viewModel.incrementVisitScore(SoccerScoreVisitModel(visitScoreResult))
                }
            )
        }
    }
}


