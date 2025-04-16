package com.bhanu.baliyar.formapplication.presentation

import androidx.compose.runtime.Composable

import com.bhanu.baliyar.formapplication.core.navigation.AppNav
import com.bhanu.baliyar.formapplication.core.navigation.AppProviders
import com.bhanu.baliyar.formapplication.core.navigation.LocalNavController


@Composable
fun FormApp() {
    AppProviders {
        val navController = LocalNavController.current
        AppNav(navController = navController)
    }
}


