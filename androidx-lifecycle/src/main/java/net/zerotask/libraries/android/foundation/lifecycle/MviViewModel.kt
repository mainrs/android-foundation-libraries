package net.zerotask.libraries.android.foundation.lifecycle

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MviViewModel<A, E, S> {
    val effect: Flow<E>
    val state: StateFlow<S>

    context(ViewModel)
    fun createInitialState(): S
    context(ViewModel)
    fun setCoroutineScope(coroutineScope: CoroutineScope)
    context(ViewModel)
    fun onAction(action: A)
    context(ViewModel)
    fun setState(reducer: S.() -> S)

    fun dispatchAction(action: A)
    fun dispatchEffect(builder: () -> E)
}
