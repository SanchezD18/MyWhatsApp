package com.example.mywhatsapp.ui.screens

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.mywhatsapp.R

@Composable
fun SmileScreen(modifier: Modifier) {
    val context = LocalContext.current
    var isSmile by remember { mutableStateOf(true) }
    val animatedDrawable = remember(isSmile) {
        try {
            AnimatedVectorDrawableCompat.create(
                context,
                if (isSmile) R.drawable.avd_smile_to_sad else R.drawable.avd_sad_to_smile
            )?.apply {
                registerAnimationCallback(
                    object : Animatable2Compat.AnimationCallback() {
                        override fun onAnimationEnd(drawable: Drawable) {
                            isSmile = !isSmile
                        }
                    }
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    Column(
        modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        AndroidView(
            factory = { ctx ->
                ImageView(ctx).apply {
                    scaleType = ImageView.ScaleType.FIT_CENTER
                    setImageResource(
                        if (isSmile) R.drawable.ic_smile else R.drawable.ic_sad
                    )
                }
            },
            update = { imageView ->
                animatedDrawable?.let { drawable ->
                    imageView.setImageDrawable(drawable)
                } ?: run {
                    val staticResId = if (isSmile) R.drawable.ic_smile else R.drawable.ic_sad
                    imageView.setImageResource(staticResId)
                }
            },
            modifier = Modifier
                .size(400.dp)
                .clickable {
                    try {
                        animatedDrawable?.start()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
        )
    }
}