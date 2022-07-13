package net.zerotask.libraries.android.foundation.domain

import androidx.paging.PagingConfig
import androidx.paging.PagingData

abstract class PagedReturnUseCase<in P : PagedReturnUseCase.Params, T : Any> :
    ReturnUseCase<P, PagingData<T>>() {
    interface Params {
        val pagingConfig: PagingConfig
    }
}
