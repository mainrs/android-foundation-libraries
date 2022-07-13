package net.zerotask.libraries.android.foundation.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest

abstract class ReturnUseCase<in P: Any, out T> {
    private val paramState: MutableSharedFlow<P> = MutableSharedFlow(
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
        replay = 1,
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow: Flow<T> = paramState
        .distinctUntilChanged()
        .flatMapLatest { createObservable(it) }
        .distinctUntilChanged()

    protected abstract fun createObservable(params: P): Flow<T>

    suspend operator fun invoke(params: P) = paramState.emit(params)
}
