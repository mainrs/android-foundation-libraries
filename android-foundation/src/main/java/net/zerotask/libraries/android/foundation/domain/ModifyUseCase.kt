package net.zerotask.libraries.android.foundation.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

sealed interface WorkStatus {
    object Started : WorkStatus
    object Finished : WorkStatus

    class Error(val throwable: Throwable) : WorkStatus
}

abstract class ModifyUseCase<in P> {
    suspend fun invoke(params: P): Flow<WorkStatus> = flow {
        try {
            emit(WorkStatus.Started)
            doWork(params)
            emit(WorkStatus.Finished)
        } catch (e: Exception) {
            emit(WorkStatus.Error(e))
        }
    }.catch { e -> emit(WorkStatus.Error(e)) }

    protected abstract suspend fun doWork(params: P)
}
