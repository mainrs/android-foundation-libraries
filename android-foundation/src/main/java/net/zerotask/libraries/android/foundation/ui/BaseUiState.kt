package net.zerotask.libraries.android.foundation.ui

@Deprecated(
    message = "The interface has been renamed to UiState",
    replaceWith = ReplaceWith(
        expression = "UiState<T>",
        imports = ["net.zerotask.libraries.android.foundation.ui"],
    ),
    level = DeprecationLevel.WARNING,
)
sealed interface BaseUiState<out T> {
    object Empty : BaseUiState<Nothing>
    object Loading : BaseUiState<Nothing>

    data class Data<T>(val value: T) : BaseUiState<T>
    data class Error(val throwable: Throwable) : BaseUiState<Nothing>
}
