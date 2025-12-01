package com.example.mywhatsapp.data

data class ContactInfo(
    val id: Int,
    val name: String,
    val photo: Int,
    val contentDescription: String? = null
)
