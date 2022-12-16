package com.example.uilayer_viewmodels_architecture

import androidx.lifecycle.ViewModel
import com.example.uilayer_viewmodels_architecture.Util.IViewState
import com.example.uilayer_viewmodels_architecture.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel : ViewModel() {

    val _uiState = MutableStateFlow("k")
    val uiState:StateFlow<String> = _uiState.asStateFlow()
}