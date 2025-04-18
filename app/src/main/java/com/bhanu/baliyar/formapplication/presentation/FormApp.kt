package com.bhanu.baliyar.formapplication.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bhanu.baliyar.formapplication.R
import com.bhanu.baliyar.formapplication.core.navigation.AppNav
import com.bhanu.baliyar.formapplication.presentation.screens.BottomNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormApp() {
    val navController: NavHostController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.home)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            BottomNav(navController = navController, currentRoute = currentRoute)
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                AppNav(
                    navController = navController
                )
            }
        }
    )
}
