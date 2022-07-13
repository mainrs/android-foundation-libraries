package net.zerotask.libraries.android.foundation.data

sealed class DataLoadingState<out T> {
    object Loading : DataLoadingState<Nothing>()
    data class Error(val error: Throwable) : DataLoadingState<Nothing>()
    data class Success<out T>(val data: T) : DataLoadingState<T>()

    override fun toString(): String =
        when (this) {
            is Loading -> "Loading"
            is Error -> "Error[throwable=$error]"
            is Success -> "Success[data=$data]"
        }
}
