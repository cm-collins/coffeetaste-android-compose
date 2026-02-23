package com.example.coffeetaste.feature.splash.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Splash screen ViewModel: holds state and emits NavigateAway after delay.
 */
class SplashViewModel : ViewModel() {

    private val _state = MutableStateFlow(SplashContract.State())
    val state: StateFlow<SplashContract.State> = _state.asStateFlow()

    private val _effect = Channel<SplashContract.Effect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    init {
        viewModelScope.launch {
            delay(1500)
            _effect.send(SplashContract.Effect.NavigateAway)
            _state.value = _state.value.copy(isLoading = false)
        }
    }
}
