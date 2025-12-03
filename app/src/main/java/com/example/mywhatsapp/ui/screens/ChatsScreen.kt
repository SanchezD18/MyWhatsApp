package com.example.mywhatsapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mywhatsapp.data.ContactInfo
import com.example.mywhatsapp.repository.ContactInfoRepository
import com.example.mywhatsapp.ui.components.CardContactInfo

@Composable
fun ChatsScreen(modifier: Modifier) {
    val contactInfo: Map<String,List<ContactInfo>> = ContactInfoRepository.getContactInfo().groupBy { it.grupo }

    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        contactInfo.forEach { (grupo, contactos) ->
            stickyHeader{
                Text(
                    text = grupo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray),
                    fontSize = 16.sp
                )
            }
            items(contactos) { contactInf ->
            CardContactInfo(
                contactInfo = contactInf,
                onClick = { /*TODO*/ }
            )
        }
    }
}}