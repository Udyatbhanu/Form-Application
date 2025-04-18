package com.bhanu.baliyar.formapplication.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class Spacing(val small: Dp = 4.dp, val medium: Dp = 8.dp, val large: Dp = 16.dp)
data class AppTypography(
    val title: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }
val LocalTypography = staticCompositionLocalOf { AppTypography() }
val LocalNavController = compositionLocalOf <NavHostController>{ error("NavHostController not provided") }

@Composable
fun AppProvider(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalTypography provides AppTypography(),
        LocalNavController provides rememberNavController()

    ) {
        content()
    }
}


