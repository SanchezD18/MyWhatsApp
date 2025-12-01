package com.example.mywhatsapp.repository

import com.example.mywhatsapp.R
import com.example.mywhatsapp.data.ContactInfo

object ContactInfoRepository {

    fun getContactInfo(): List<ContactInfo> = listOf(
        ContactInfo(
            id = 1,
            name = "Jefe de departamento",
            photo = R.drawable.image1,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Tutora DAM",
            photo = R.drawable.image2,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Tutora DAW",
            photo = R.drawable.image3,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Tutor ASIX",
            photo = R.drawable.image4,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Presidenta",
            photo = R.drawable.image5,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Secretaria",
            photo = R.drawable.image6,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Administrador",
            photo = R.drawable.image7,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Entrenadora",
            photo = R.drawable.image8,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Nutricionista",
            photo = R.drawable.image1,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            name = "Fisioterapeuta",
            photo = R.drawable.image2,
            contentDescription = null
        ),
        )
}