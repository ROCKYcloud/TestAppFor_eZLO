package com.example.ezlotestapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.ezlotestapp.ui.view.SharedViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ezlotestapp.ui.view.components.DeviseItem
import com.example.ezlotestapp.ui.view.components.ErrorView
import com.example.ezlotestapp.ui.view.components.HeaderItem

@Composable
fun ListScreen(viewModel: SharedViewModel, navController: NavController) {
    val devices by remember { viewModel.devices }
    val isLoading by remember { viewModel.isLoading }
    val isError by remember { viewModel.isError }

    if (isLoading) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(color = Color.Blue)
        }

    } else {
        Column {
            if (isError) {
                ErrorView(
                    errorMessage = "No internet connection, click to refresh",
                    onClick = { viewModel.getDevices() }
                )
            }
            HeaderItem()
            LazyColumn() {
                items(devices) { item ->
                    DeviseItem(device = item, onClick = {
                        viewModel.addDevice(item)
                        navController.navigate(Graph.DETAIL_SCREEN.route)
                    },
                        onLongClick = {
                            viewModel.deleteDevice(item)
                        }
                    )
                    Divider(color = Color.Gray, thickness = 1.dp)
                }
            }
        }
    }
}


