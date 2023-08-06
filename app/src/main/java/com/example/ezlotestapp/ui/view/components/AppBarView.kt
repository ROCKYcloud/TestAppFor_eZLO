package com.example.ezlotestapp.ui.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AppBarView(onNavBack: () -> Unit, isEdit: Boolean, onEdit: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { onNavBack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "search",
                tint = Color.Blue
            )
        }
        IconButton(onClick = { onEdit() }) {
            Icon(
                imageVector = if (!isEdit) Icons.Default.Edit else Icons.Default.Check,
                contentDescription = "search",
                tint = Color.Blue
            )
        }
    }
}