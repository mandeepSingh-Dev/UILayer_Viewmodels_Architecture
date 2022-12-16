package com.example.uilayer_viewmodels_architecture.presentation.base

import com.example.uilayer_viewmodels_architecture.Util.IEvent
import com.example.uilayer_viewmodels_architecture.Util.IViewEvent
import com.example.uilayer_viewmodels_architecture.Util.IViewState
import kotlinx.coroutines.flow.*

abstract class BaseViewModel<State : IViewState, UIEvent : IEvent, ViewModelEvent : IViewEvent> {

    /**Initializing State (IViewState) here by implementing 'createInitialState' method in child Viewmodels */
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    /** Creating MutableStateFlow of State */
    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState: StateFlow<State> = _uiState

    /**Getting currentstate of uiState*/
    val currentState: State get() = uiState.value


    abstract fun onTriggerEvent(event: ViewModelEvent)

    /**Creating MutableStateFlow of UIEvent */
    private val _uiViewModelEvent: MutableSharedFlow<UIEvent> = MutableSharedFlow()
    val uiEvent = _uiViewModelEvent.asSharedFlow()

    protected fun setState(state: () -> State) {
        val newState = state()
        _uiState.value = newState
    }

    protected fun setEvent(uiEvent: UIEvent) {
      //  viewModelScope.launch { _uiViewModelEvent.emit(uiEvent) }
    }

    protected open fun handleError(message: String? = null) {}

    protected open fun handleLoading(showLoading: Boolean) {}

}