package com.example.mywhatsapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun NovedadesScreen(modifier: Modifier) {
    Column(modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally) {
        Text(text = "En desarrollo...")
    }
}