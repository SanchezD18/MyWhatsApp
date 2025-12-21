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
fun StarScreen(modifier: Modifier) {
    val context = LocalContext.current
    var shouldAnimate by remember { mutableStateOf(false) }
    
    val animatedDrawable = remember {
        try {
            AnimatedVectorDrawableCompat.create(
                context,
                R.drawable.avd_star_draw
            )
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
                    setImageResource(R.drawable.ic_star)
                }
            },
            update = { imageView ->
                if (shouldAnimate) {
                    animatedDrawable?.let { drawable ->
                        imageView.setImageDrawable(drawable)
                        drawable.start()
                    } ?: run {
                        imageView.setImageResource(R.drawable.ic_star)
                    }
                } else {
                    imageView.setImageResource(R.drawable.ic_star)
                }
            },
            modifier = Modifier
                .size(400.dp)
                .clickable {
                    shouldAnimate = true
                    try {
                        animatedDrawable?.start()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
        )
    }
}