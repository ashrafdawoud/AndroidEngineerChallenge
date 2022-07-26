package com.dawoud.data.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "PopularMovieTable")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "adult")
    val adult : Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdrop_path : String?,
    @ColumnInfo(name = "original_language")
    val original_language :String,
    @ColumnInfo(name = "original_title")
    val original_title :String,
    @ColumnInfo(name = "overview")
    val overview :String,
    @ColumnInfo(name = "popularity")
    val popularity :Double,
    @ColumnInfo(name = "poster_path")
    val poster_path :String?,
    @ColumnInfo(name = "release_date")
    val release_date :String,
    @ColumnInfo(name = "title")
    val title :String
)
