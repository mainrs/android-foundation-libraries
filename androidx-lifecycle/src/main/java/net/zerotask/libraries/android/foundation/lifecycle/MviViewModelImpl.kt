package net.zerotask.libraries.android.foundation.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * A [ViewModel] implementation following the MVI pattern.
 *
 * @param A The set of actions that can be send from the UI layer to the [ViewModel].
 * @param S The state that the UI layer represents.
 * @param E The side-effects that the [ViewModel] can trigger.
 */
class MviViewModelImpl<A, E, S> : MviViewModel<A, E, S> {
    private val initialState: S by lazy { createInitialState() }

    private val _action: MutableSharedFlow<A> = MutableSharedFlow()

    private val _effect: Channel<E> = Channel()
    override val effect: Flow<E> = _effect.receiveAsFlow()

    private val _state: MutableStateFlow<S> by lazy { MutableStateFlow(initialState) }
    override val state: StateFlow<S> by lazy { _state.asStateFlow() }

    private lateinit var coroutineScope: CoroutineScope

    /**
     * Dispatches an action to the [ViewModel].
     */
    override fun dispatchAction(action: A) {
        coroutineScope.launch { _action.emit(action) }
    }

    /**
     * Dispatches an action to the effect channel.
     */
    override fun dispatchEffect(builder: () -> E) {
        val effect = builder()
        coroutineScope.launch { _effect.send(effect) }
    }

    /**
     * A helper function to update the current state.
     */
    context(ViewModel)
    override fun setState(reducer: S.() -> S) {
        val newState = state.value.reducer()
        _state.value = newState
    }

    init {
        coroutineScope.launch {
            _action.collect {
                onAction(it)
            }
        }
    }

    override fun createInitialState(): S {
        TODO("Not yet implemented")
    }

    context(ViewModel) override fun setCoroutineScope(coroutineScope: CoroutineScope) {
        this.coroutineScope = coroutineScope
    }

    override fun onAction(action: A) {
        TODO("Not yet implemented")
    }
}
