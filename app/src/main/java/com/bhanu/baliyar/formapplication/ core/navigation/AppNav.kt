package com.bhanu.baliyar.formapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bhanu.baliyar.formapplication.presentation.screens.DetailsScreen
import com.bhanu.baliyar.formapplication.presentation.screens.HomeScreen


@Composable
fun AppNav(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Route.Home.route
    ) {
        composable(Route.Home.route) {
            HomeScreen()
        }
        composable(Route.Details.route) {
            DetailsScreen()
        }
    }
}