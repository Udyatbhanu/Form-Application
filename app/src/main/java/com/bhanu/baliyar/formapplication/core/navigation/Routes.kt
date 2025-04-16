package com.bhanu.baliyar.formapplication.core.navigation

sealed class Routes(val route : String) {
    object Form : Routes(route = "form")
    object Details : Routes(route = "details")
}