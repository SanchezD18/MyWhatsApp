package com.example.mywhatsapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mywhatsapp.repository.ContactInfoRepository
import com.example.mywhatsapp.ui.components.CardContactInfo

@Composable
fun ChatsScreen(modifier: Modifier) {
    val contactInfo = remember { ContactInfoRepository.getContactInfo() }

    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(contactInfo) { contactInf ->
            CardContactInfo(
                contactInfo = contactInf,
                onClick = { /*TODO*/ }
            )
        }
    }
}