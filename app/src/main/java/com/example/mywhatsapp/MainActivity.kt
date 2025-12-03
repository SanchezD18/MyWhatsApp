package com.example.mywhatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import com.example.mywhatsapp.ui.components.TopAppBarCustom
import com.example.mywhatsapp.ui.screens.ChatsScreen
import com.example.mywhatsapp.ui.screens.LlamadasScreen
import com.example.mywhatsapp.ui.screens.NovedadesScreen
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
                    topBar = { TopAppBarCustom(scrollBehavior) }) { innerPadding ->
                    MyWhatsApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MyWhatsApp(modifier: Modifier = Modifier) {
    val titles = listOf("Chats", "Llamadas", "Novedades")
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
                1 -> LlamadasScreen(Modifier)
                2 -> NovedadesScreen(Modifier)
            }
        }
    }
}