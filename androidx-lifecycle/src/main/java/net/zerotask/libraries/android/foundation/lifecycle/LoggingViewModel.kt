package net.zerotask.libraries.android.foundation.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class LoggingViewModel : ViewModel() {
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
        handleException(throwable)
    }

    protected open fun handleException(throwable: Throwable) {}

    protected fun launchAndLog(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(context = exceptionHandler, block = block)
    }
}
