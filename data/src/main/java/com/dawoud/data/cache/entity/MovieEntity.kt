package com.dawoud.data.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieTable")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int
)
