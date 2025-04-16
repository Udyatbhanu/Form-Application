package com.bhanu.baliyar.formapplication.presentation.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FormScreenViewModel : ViewModel(){
    private val _state = mutableStateOf(FormData())
    val state = _state
}