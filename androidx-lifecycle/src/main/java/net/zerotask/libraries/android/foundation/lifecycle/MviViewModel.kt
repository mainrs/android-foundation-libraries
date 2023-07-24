package net.zerotask.libraries.android.foundation.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
 * @param ACTION The set of actions that can be send from the UI layer to the [ViewModel].
 * @param STATE The state that the UI layer represents.
 * @param EFFECT The side-effects that the [ViewModel] can trigger.
 */
abstract class MviViewModel<ACTION, STATE, EFFECT> : LoggingViewModel() {
    private val initialState: STATE by lazy { createInitialState() }

    private val _action: MutableSharedFlow<ACTION> = MutableSharedFlow()

    private val _effect: Channel<EFFECT> = Channel()
    val effect: Flow<EFFECT> = _effect.receiveAsFlow()

    private val _state: MutableStateFlow<STATE> by lazy { MutableStateFlow(initialState) }
    val state: StateFlow<STATE> by lazy { _state.asStateFlow() }

    protected abstract fun onAction(action: ACTION)
    protected abstract fun createInitialState(): STATE

    /**
     * Dispatches an action to the [ViewModel].
     */
    fun dispatchAction(action: ACTION) {
        viewModelScope.launch { _action.emit(action) }
    }

    /**
     * Dispatches an action to the effect channel.
     */
    protected fun dispatchEffect(builder: () -> EFFECT) {
        val effect = builder()
        viewModelScope.launch { _effect.send(effect) }
    }

    /**
     * A helper function to update the current state.
     */
    protected fun setState(reducer: STATE.() -> STATE) {
        val newState = state.value.reducer()
        _state.value = newState
    }

    init {
        viewModelScope.launch {
            _action.collect {
                onAction(it)
            }
        }
    }
}
