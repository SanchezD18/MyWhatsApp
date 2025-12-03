package com.example.mywhatsapp.data

data class ContactInfo(
    val id: Int,
    val grupo: String,
    val name: String,
    val photo: Int,
    val contentDescription: String? = null
)
