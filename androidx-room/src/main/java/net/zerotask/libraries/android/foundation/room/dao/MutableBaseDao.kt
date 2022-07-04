package net.zerotask.libraries.android.foundation.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import net.zerotask.libraries.android.foundation.room.entity.BaseEntity

interface MutableBaseDao<T : BaseEntity> {
    @Delete
    fun delete(obj: T)

    @Delete
    fun deleteAll(objects: List<T>)

    @Insert
    fun insert(obj: T): Long

    @Insert
    fun insertAll(objects: List<T>)

    @Update
    fun update(obj: T)

    @Update
    fun updateAll(objects: List<T>)
}
