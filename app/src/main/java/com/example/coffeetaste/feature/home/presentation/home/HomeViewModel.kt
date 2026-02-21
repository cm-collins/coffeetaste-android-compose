package com.example.coffeetaste.feature.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Home screen ViewModel: holds state, handles events, emits effects.
 */
class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeContract.State())
    val state: StateFlow<HomeContract.State> = _state.asStateFlow()

    private val _effect = Channel<HomeContract.Effect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: HomeContract.Event) {
        when (event) {
            HomeContract.Event.Refresh -> viewModelScope.launch {
                _state.update { it.copy(isLoading = true) }
                // TODO: Load home data
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}
