package com.bhanu.baliyar.formapplication.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class AppSpacing(val small: Dp = 4.dp, val medium: Dp = 8.dp, val large: Dp = 16.dp)

val LocalSpacing = staticCompositionLocalOf { AppSpacing() }
val  LocalNavProvider = compositionLocalOf<NavHostController> {  error("Nav controller not provided") }

@Composable
fun AppProviders(navController: NavHostController = rememberNavController(),content : @Composable () -> Unit){
    CompositionLocalProvider(
        LocalNavProvider provides navController,
        LocalSpacing provides AppSpacing()) {
        content()
    }

}