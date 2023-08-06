package com.example.ezlotestapp.ui.view.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ezlotestapp.R
import com.example.ezlotestapp.data.models.Device
import com.example.ezlotestapp.utils.Constants

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DeviseItem(
    device: Device,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    val openDialog = remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(horizontal = 16.dp)
        .combinedClickable(
            onClick = { onClick() },
            onLongClick = {
                openDialog.value = true
            }
        ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .padding(horizontal = 16.dp),
            model = device.urlImg,
            contentDescription = "",
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = device.platform,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = device.pKDevice.toString())
        }
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "search",
            tint = Color.Gray
        )

    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = { Text(text = "Delete devise ${device.platform}") },
            text = { Text("do you rely wont to delete this devise?") },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                        onLongClick()
                    }) {
                    Text(Constants.delete)
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    }) {
                    Text(Constants.cansel)
                }
            }
        )
    }
}