package com.bhanu.baliyar.formapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController

val LocalNavController = compositionLocalOf <NavHostController>{
    error("Nav controller not provided")
}

@Composable
fun AppProviders(content : @Composable () -> Unit){
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        content()
    }

}