package com.dawoud.data.cache.entity

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

@Entity(tableName = "PopularMovieTable")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "adult")
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String?,
    @ColumnInfo(name = "original_language")
    val original_language:String,
    @ColumnInfo(name = "original_title")
    val original_title:String,
    @ColumnInfo(name = "overview")
    val overview:String,
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @ColumnInfo(name = "poster_path")
    val poster_path:String?,
    @ColumnInfo(name = "release_date")
    val release_date:String,
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "genre_ids")
    @TypeConverters(Genre_idsConverters::class)
    val genre_ids:List<Int>,
    @ColumnInfo(name = "vote_count")
    val vote_count:Int,
    @ColumnInfo(name = "video")
    val video:Boolean,
    @ColumnInfo(name = "vote_average")
    val vote_average:Double,
)
class Genre_idsConverters {
    @TypeConverter
    fun fromcastJson(stat: List<Int>): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun tocastEntity(json: String): List<Int> {
        val type = object : TypeToken<List<CastEntity>>() {}.type
        return Gson().fromJson<List<Int>>(json, type)
    }
}
