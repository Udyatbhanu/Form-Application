package com.bhanu.baliyar.formapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bhanu.baliyar.formapplication.presentation.screens.DetailsScreen
import com.bhanu.baliyar.formapplication.presentation.screens.FormScreen


@Composable
fun AppNav(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.Form.route,
        modifier = modifier
    ) {
        composable(Routes.Form.route) {
            FormScreen(navController = navController)
        }
        composable(Routes.Details.route) {
            DetailsScreen()
        }
    }
}