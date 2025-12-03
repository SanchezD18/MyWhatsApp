package com.example.mywhatsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mywhatsapp.data.ContactInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardContactInfo(
    contactInfo: ContactInfo,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .pointerInput(true) {
            detectTapGestures(onLongPress = {
                expanded = true })
        },
            verticalAlignment = Alignment.CenterVertically,
         ) {
            Image(
                painter = painterResource(id = contactInfo.photo),
                contentDescription = contactInfo.contentDescription,
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(70.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = contactInfo.name,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 15.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF000000)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
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
}