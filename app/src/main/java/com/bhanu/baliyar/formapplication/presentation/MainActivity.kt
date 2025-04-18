package com.bhanu.baliyar.formapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bhanu.baliyar.formapplication.core.AppProvider
import com.bhanu.baliyar.formapplication.core.LocalSpacing
import com.bhanu.baliyar.formapplication.core.Spacing
import com.bhanu.baliyar.formapplication.presentation.theme.FormApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormApplicationTheme {
                AppProvider {
                    FormApp()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormApplicationTheme {
        FormApp()
    }
}