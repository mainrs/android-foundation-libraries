package net.zerotask.libraries.android.foundation.room.entity

import java.time.OffsetDateTime

abstract class BaseEntityWithTimestamp : BaseEntity() {
    var createdAt: OffsetDateTime = OffsetDateTime.now()
    var updatedAt: OffsetDateTime = OffsetDateTime.now()
}
