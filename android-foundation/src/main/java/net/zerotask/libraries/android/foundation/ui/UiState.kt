package net.zerotask.libraries.android.foundation.ui

sealed interface UiState<out T> {
    object Empty : UiState<Nothing>
    object Loading : UiState<Nothing>

    data class Data<T>(val value: T) : UiState<T>
    data class Error(val throwable: Throwable) : UiState<Nothing>
}
