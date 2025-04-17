package com.bhanu.baliyar.formapplication.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button

import androidx.compose.material3.DropdownMenuItem

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bhanu.baliyar.formapplication.R
import com.bhanu.baliyar.formapplication.core.LocalNavProvider
import com.bhanu.baliyar.formapplication.core.LocalSpacing
import com.bhanu.baliyar.formapplication.core.navigation.Routes
import com.bhanu.baliyar.formapplication.presentation.components.SimpleAlertDialog


val fruits = listOf<String>("Apple", "Banana", "Orange", "Mango")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: SearchScreenViewModel = viewModel()) {
    val navController = LocalNavProvider.current
    val spacing = LocalSpacing.current
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Search Screen") },
            )
        },
        content = { innerPadding ->
            var query by remember { mutableStateOf("") }

            val filteredFruits = remember(query) {
                if (query.isBlank()) fruits
                else fruits.filter { it.contains(query, ignoreCase = true) }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(spacing.large)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    OutlinedTextField(
                        value = query,
                        onValueChange = { query = it },
                        label = { Text(stringResource(R.string.search_fruits)) },
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = "Search Icon")
                        },

                        trailingIcon = {
                            if (query.isNotEmpty()) {
                                IconButton(onClick = { query = "" }) {
                                    Icon(Icons.Default.Clear, contentDescription = "Clear")
                                }
                            }
                        },
                        singleLine = true
                    )

                    Spacer(Modifier.height(8.dp))
                    SimpleDropdownMenu()
                    Spacer(Modifier.height(8.dp))
                    FruitsList(filteredFruits)
                }
                Button(
                    modifier = Modifier.fillMaxWidth().align (Alignment.BottomCenter),
                    onClick = {

                        navController.navigate(Routes.Details.route)

                              },
                    shape = RoundedCornerShape(7.dp),
                    content = { Text("Click Me") }
                )
            }

        })
}

@Composable
fun FruitsList(filteredFruits: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        items(filteredFruits) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDropdownMenu() {
    val options = listOf("Apple", "Banana", "Orange", "Mango")
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        // TextField anchor
        OutlinedTextField(
            readOnly = true,
            value = selectedOption,
            onValueChange = {},
            label = { Text("Choose fruit") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        // Dropdown options
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
            }
        }
    }
}