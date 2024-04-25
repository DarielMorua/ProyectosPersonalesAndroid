package com.dariel.relaxulsa.soccer

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dariel.relaxulsa.R

@Composable
fun SoccerScreen(viewModel: SoccerScoreViewModel) {
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
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clickable {
                        Log.d("sumarr", "local")
                        viewModel.incrementLocalScore(SoccerScoreLocalModel(localScoreResult))
                    }
            )
            Text(
                text = "${localScoreResult}",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "${visitScoreResult}",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(id = R.drawable.i),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clickable {
                        print("sumar")
                        Log.d("sumarr", "visitante")
                        viewModel.incrementVisitScore(SoccerScoreVisitModel(visitScoreResult))
                    }
            )

        }
    }

}





