package com.example.ezlotestapp.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ezlotestapp.R
import com.example.ezlotestapp.ui.view.components.AppBarView
import com.example.ezlotestapp.ui.view.components.HeaderItem
import com.example.ezlotestapp.ui.view.components.MultiStyleText
import com.example.ezlotestapp.utils.Constants

@Composable
fun DetailScreen(viewModel: SharedViewModel, navController: NavController) {
    viewModel.device?.let { item ->
        val isEdit = remember { mutableStateOf(false) }
        val title = remember { mutableStateOf(item.platform) }
        Column() {
            AppBarView(
                isEdit = isEdit.value,
                onNavBack = { navController.popBackStack() },
                onEdit = {
                    when {
                        isEdit.value -> {
                            isEdit.value = false
                            item.platform = title.value
                            viewModel.editDevice(item)
                        }
                        else -> {
                            isEdit.value = true
                        }
                    }
                }
            )
            HeaderItem()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                        .padding(horizontal = 16.dp),
                    model = item.urlImg,
                    contentDescription = "",
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentScale = ContentScale.Crop
                )
                when {
                    !isEdit.value -> Text(
                        text = item.platform,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    else -> TextField(
                        value = title.value,
                        onValueChange = {
                            title.value = it
                        }
                    )
                }
            }
            Column(modifier = Modifier.padding(all = 16.dp)) {
                MultiStyleText(title = Constants.sN, info = item.pKDevice.toString())
                MultiStyleText(title = Constants.model, info = item.platform)
                MultiStyleText(title = Constants.firmware, info = item.firmware.toString())
                MultiStyleText(title = Constants.macAddress, info = item.macAddress.toString())
            }
        }
    }
}