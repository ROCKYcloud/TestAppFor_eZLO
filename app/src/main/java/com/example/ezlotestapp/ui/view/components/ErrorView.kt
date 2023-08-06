package com.example.ezlotestapp.ui.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ErrorView(errorMessage: String,onClick:() -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth().height(40.dp)
            .background(color = Color.Red)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = errorMessage, color = Color.White)
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "refresh",
            tint = Color.White
        )
    }
}