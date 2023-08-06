package com.example.ezlotestapp.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ezlotestapp.ui.view.DetailScreen
import com.example.ezlotestapp.ui.view.SharedViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: SharedViewModel) {
    NavHost(navController, startDestination = Graph.DEVICES_SCREEN.route) {
        composable(Graph.DEVICES_SCREEN.route) {
            ListScreen(viewModel = viewModel, navController = navController)
        }
        composable(Graph.DETAIL_SCREEN.route) {
            DetailScreen(navController = navController, viewModel = viewModel)
        }
    }
}

sealed class Graph(val route: String) {
    object DEVICES_SCREEN : Graph(route = "devises_screen")
    object DETAIL_SCREEN : Graph("detail_screen")
}