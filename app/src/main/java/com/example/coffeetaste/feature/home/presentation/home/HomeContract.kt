package com.example.coffeetaste.feature.home.presentation.home

/**
 * Home screen contract.
 *
 * **State:** UI state (e.g. isLoading, message). The Screen displays this; ViewModel updates it when data is loaded.
 *
 * **Event:** User actions (e.g. Refresh). The Screen sends these; ViewModel loads data or performs work.
 *
 * **Effect:** One-shot UI feedback (e.g. ShowMessage for toasts). The host or Screen can collect and show them.
 */
object HomeContract {

    data class State(
        val isLoading: Boolean = false,
        val message: String = ""
    )

    sealed interface Event {
        data object Refresh : Event
    }

    sealed interface Effect {
        data class ShowMessage(val text: String) : Effect
    }
}
