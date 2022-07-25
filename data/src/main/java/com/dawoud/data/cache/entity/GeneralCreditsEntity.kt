package com.dawoud.data.cache.entity

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "CreditsTable")
data class GeneralCreditsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "cast")
    @TypeConverters(CastConverters::class)
    val cast: List<CastEntity>
)

 class CastEntity(
    @ColumnInfo(name ="adult")
    val adult: Boolean,
    @ColumnInfo(name ="gender")
    val gender: Int?,
    @ColumnInfo(name ="iidd")
    val id: Int,
    @ColumnInfo(name ="known_for_department")
    val known_for_department: String,
    @ColumnInfo(name ="name")
    val name: String,
    @ColumnInfo(name ="original_name")
    val original_name: String,
    @ColumnInfo(name ="popularity")
    val popularity: Long,
    @ColumnInfo(name ="profile_path")
    val profile_path: String?,
    @ColumnInfo(name ="cast_id")
    val cast_id: Int,
    @ColumnInfo(name ="character")
    val character: String,
    @ColumnInfo(name ="credit_id")
    val credit_id: String,
    @ColumnInfo(name ="order")
    val order: Int,
)
class CastConverters {
    @TypeConverter
    fun fromcastJson(stat: List<CastEntity>): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun tocastEntity(json: String): List<CastEntity> {
        val type = object : TypeToken<List<CastEntity>>() {}.type
        return Gson().fromJson<List<CastEntity>>(json, type)
    }
}