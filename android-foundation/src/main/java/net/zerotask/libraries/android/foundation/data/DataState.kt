package net.zerotask.libraries.android.foundation.data

sealed class DataState<out T> {
    data class Error(val error: Throwable) : DataState<Nothing>()
    data class Success<out T>(val data: T) : DataState<T>()

    override fun toString(): String =
        when (this) {
            is Error -> "Error[throwable=$error]"
            is Success -> "Success[data=$data]"
        }
}
