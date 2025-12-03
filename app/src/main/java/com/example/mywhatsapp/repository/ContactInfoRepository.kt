package com.example.mywhatsapp.repository

import com.example.mywhatsapp.R
import com.example.mywhatsapp.data.ContactInfo

object ContactInfoRepository {

    fun getContactInfo(): List<ContactInfo> = listOf(
        ContactInfo(
            id = 1,
            grupo = "Departamento de informática",
            name = "Jefe de departamento",
            photo = R.drawable.image1,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Departamento de informática",
            name = "Tutora DAM",
            photo = R.drawable.image2,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Departamento de informática",
            name = "Tutora DAW",
            photo = R.drawable.image3,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Departamento de informática",
            name = "Tutor ASIX",
            photo = R.drawable.image4,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Comunidad Propietarios",
            name = "Presidenta",
            photo = R.drawable.image5,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Comunidad Propietarios",
            name = "Secretaria",
            photo = R.drawable.image6,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Comunidad Propietarios",
            name = "Administrador",
            photo = R.drawable.image7,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Gimnasio",
            name = "Entrenadora",
            photo = R.drawable.image8,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Gimnasio",
            name = "Nutricionista",
            photo = R.drawable.image1,
            contentDescription = null
        ),
        ContactInfo(
            id = 2,
            grupo = "Gimnasio",
            name = "Fisioterapeuta",
            photo = R.drawable.image2,
            contentDescription = null
        ),
        )
}