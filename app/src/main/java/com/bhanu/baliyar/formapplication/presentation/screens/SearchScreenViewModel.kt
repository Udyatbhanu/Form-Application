package com.bhanu.baliyar.formapplication.presentation.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchScreenViewModel : ViewModel() {

    private val _fruits = MutableStateFlow<List<String>>(listOf<String>("Apple", "Banana", "Orange", "Mango"))
    val fruits : StateFlow<List<String>> = _fruits
}