package com.example.ezlotestapp.ui.view.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun MultiStyleText(title: String, info: String) {
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Gray)) {
            append(title)
        }
        withStyle(style = SpanStyle(color = Color.Gray)) {
            append(": ")
        }
        withStyle(style = SpanStyle(color = Color.Black)) {
            append(info)
        }
    }, fontSize = 20.sp)
}