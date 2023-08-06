package com.example.ezlotestapp.ui.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ezlotestapp.R

@Composable
fun HeaderItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            modifier = Modifier
                .width(150.dp)
                .height(120.dp)
                .padding(horizontal = 16.dp)
                .clip(
                    RoundedCornerShape(16.dp)),
            model = "https://www.sideshow.com/storage/product-images/904599/iron-man-mark-lxxxv_marvel_square.jpg",
            contentDescription = "",
            error = painterResource(R.drawable.ic_launcher_background),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "John Wayne",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}