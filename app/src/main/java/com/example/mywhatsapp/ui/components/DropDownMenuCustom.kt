package com.example.mywhatsapp.ui.components

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DropdownMenuCustom(
    expanded: Boolean,
    onDismissRequest: () -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            text = { Text("Salir del grupo") },
            onClick = {
                /*TODO*/
            }
        )
        DropdownMenuItem(
            text = { Text("Info. grupo") },
            onClick = {
                /*TODO*/
            }
        )
        DropdownMenuItem(
            text = { Text("Crear acceso directo") },
            onClick = {
                /*TODO*/
            }
        )
    }
}