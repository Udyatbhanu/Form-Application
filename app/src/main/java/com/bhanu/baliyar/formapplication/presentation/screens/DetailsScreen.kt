package com.bhanu.baliyar.formapplication.presentation.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bhanu.baliyar.formapplication.core.LocalNavProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen() {
    val navController = LocalNavProvider.current
    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = {
        TopAppBar(
            title = { Text(text = "Details") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            ),
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        )
    }, content = { innerPadding ->
        Text(modifier = Modifier.padding(innerPadding), text = "DetailsScreen")
    })
}