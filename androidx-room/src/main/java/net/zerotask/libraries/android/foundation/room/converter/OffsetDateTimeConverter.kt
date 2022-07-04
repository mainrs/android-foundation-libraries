package net.zerotask.libraries.android.foundation.room.converter

import androidx.room.TypeConverter
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

object OffsetDateTimeConverter {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @JvmStatic
    @TypeConverter
    fun toOffsetDateTime(value: String?): OffsetDateTime? =
        value?.let { formatter.parse(it, OffsetDateTime::from) }

    @JvmStatic
    @TypeConverter
    fun fromOffsetDateTime(value: OffsetDateTime?): String? =
        value?.let { formatter.format(it) }
}
