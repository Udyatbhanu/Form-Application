package com.bhanu.baliyar.formapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bhanu.baliyar.formapplication.core.LocalNavProvider
import com.bhanu.baliyar.formapplication.presentation.screens.DetailsScreen
import com.bhanu.baliyar.formapplication.presentation.screens.SearchScreen


sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Details : Routes("details")

}

@Composable
fun AppNav(modifier: Modifier = Modifier) {
    val navController = LocalNavProvider.current
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            SearchScreen()
        }
        composable(Routes.Details.route) {
            DetailsScreen()
        }
    }
}