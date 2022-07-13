package net.zerotask.apps.android.foundation.compose.datastore

import androidx.compose.runtime.*
import androidx.datastore.core.DataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@Composable
fun <T, P> rememberDataStoreValue(
    dataStore: DataStore<P>,
    selector: (P) -> T,
    updater: (T) -> P,
    defaultValue: T,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): MutableState<T> {
    val state = remember {
        dataStore.data.map(selector)
    }.collectAsState(initial = defaultValue)

    return remember {
        object : MutableState<T> {
            override var value: T
                get() = state.value
                set(value) {
                    coroutineScope.launch {
                        dataStore.updateData {
                            val newData = updater(value)
                            newData
                        }
                    }
                }

            override fun component1(): T = value

            override fun component2(): (T) -> Unit = { value = it }
        }
    }
}
