package com.bhanu.baliyar.formapplication.core.navigation

sealed class Route(val route : String) {
    object Home : Route("Home")
    object Details : Route("Details")
}