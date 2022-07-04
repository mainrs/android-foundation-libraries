package net.zerotask.libraries.android.foundation.room.entity

import androidx.room.PrimaryKey

abstract class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
