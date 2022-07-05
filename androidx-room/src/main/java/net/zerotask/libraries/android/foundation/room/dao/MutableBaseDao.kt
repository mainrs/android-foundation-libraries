package net.zerotask.libraries.android.foundation.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import net.zerotask.libraries.android.foundation.room.entity.BaseEntity

interface MutableBaseDao<T : BaseEntity> {
    @Delete
    suspend fun delete(obj: T)

    @Delete
    suspend fun deleteAll(objects: List<T>)

    @Insert
    suspend fun insert(obj: T): Long

    @Insert
    suspend fun insertAll(objects: List<T>)

    @Update
    suspend fun update(obj: T)

    @Update
    suspend fun updateAll(objects: List<T>)
}
