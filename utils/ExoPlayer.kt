import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.dariel.relaxulsa.R
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun ExoPlayerExample(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val videoUri = Uri.parse("android.resource://${context.packageName}/${R.raw.login}")
    val mediaItem = MediaItem.Builder()
        .setUri(videoUri)
        .build()
    val exoPlayer = remember(context, mediaItem) {
        ExoPlayer.Builder(context)
            .build()
            .also { exoPlayer ->
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.prepare()
                exoPlayer.playWhenReady = true
                exoPlayer.repeatMode = Player.REPEAT_MODE_ALL
                exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
            }
    }

    AndroidView(
        factory = {
            StyledPlayerView(context).apply {
                player = exoPlayer
                useController = false  // Deshabilitar los controles

                // Aquí ajustamos el modo de escalado para que el video llene toda la pantalla
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM

                layoutParams = android.view.ViewGroup.LayoutParams(
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        },
        modifier = modifier.fillMaxSize()  // Asegurarnos que el contenedor también ocupe todo el espacio
    )

    DisposableEffect(exoPlayer) {
        onDispose {
            exoPlayer.release()
        }
    }
}