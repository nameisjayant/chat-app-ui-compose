package com.nameisjayant.chatappui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nameisjayant.chatappui.data.Person

@Composable
fun ChatScreen() {


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){



    }

}

@Composable
fun UserNameRow(
    modifier: Modifier = Modifier,
    person: Person
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = person.icon),
            contentDescription = "",
            modifier = Modifier.size(42.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(10.dp))

    }

}