package com.bhanu.baliyar.formapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.bhanu.baliyar.formapplication.core.AppProviders

import com.bhanu.baliyar.formapplication.presentation.theme.FormApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormApplicationTheme {
                AppProviders {
                    SearchApp()
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormApplicationTheme {
        SearchApp()
    }
}