package net.zerotask.libraries.android.foundation.room.dao

import net.zerotask.libraries.android.foundation.room.entity.BaseEntityWithTimestamp
import java.time.OffsetDateTime

interface MutableBaseDaoWithTimestamp<T : BaseEntityWithTimestamp> : MutableBaseDao<T> {
    suspend fun updateAndUpdateTimestamps(obj: T) {
        update(obj.apply {
            updatedAt = OffsetDateTime.now()
        })
    }
}
