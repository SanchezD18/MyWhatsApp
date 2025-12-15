package com.example.mywhatsapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import android.widget.ImageView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.mywhatsapp.ui.components.TopAppBarCustom
import com.example.mywhatsapp.ui.screens.ChatsScreen
import com.example.mywhatsapp.ui.screens.SmileScreen
import com.example.mywhatsapp.ui.screens.PauseStartScreen
import com.example.mywhatsapp.ui.theme.MyWhatsAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
            
            MyWhatsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = { TopAppBarCustom(scrollBehavior) },
                    floatingActionButton = {
                        CustomFab()
                    }) { innerPadding ->
                    MyWhatsApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MyWhatsApp(modifier: Modifier = Modifier) {
    val titles = listOf("Chats", "Pause/Start", "Smile")
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { titles.size })

    LaunchedEffect(pagerState.currentPage) {
    }

    Column(modifier) {
        PrimaryTabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = Color(0xFF018A7C),
            contentColor = Color.White
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> ChatsScreen(Modifier)
                1 -> PauseStartScreen(Modifier)
                2 -> SmileScreen(Modifier)
            }
        }
    }
}



@Composable
fun CustomFab(){
    val context = LocalContext.current
    var isTick by remember { mutableStateOf(true) }
    val animatedDrawable = remember(isTick) {
        try {
            AnimatedVectorDrawableCompat.create(
                context,
                if (isTick) R.drawable.avd_tick_to_cross else R.drawable.avd_cross_to_tick
            )?.apply {
                registerAnimationCallback(
                    object : Animatable2Compat.AnimationCallback() {
                        override fun onAnimationEnd(drawable: Drawable) {
                            isTick = !isTick
                        }
                    }
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    FloatingActionButton(
        onClick = {
            try {
                animatedDrawable?.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        modifier = Modifier.size(56.dp)
    ) {
        AndroidView(
            factory = { ctx ->
                ImageView(ctx).apply {
                    scaleType = ImageView.ScaleType.FIT_CENTER
                    setImageResource(
                        if (isTick) R.drawable.ic_tick else R.drawable.ic_cross
                    )
                }
            },
            update = { imageView ->
                animatedDrawable?.let { drawable ->
                    imageView.setImageDrawable(drawable)
                } ?: run {
                    val staticResId = if (isTick) R.drawable.ic_tick else R.drawable.ic_cross
                    imageView.setImageResource(staticResId)
                }
            },
            modifier = Modifier.size(24.dp)
        )
    }
}