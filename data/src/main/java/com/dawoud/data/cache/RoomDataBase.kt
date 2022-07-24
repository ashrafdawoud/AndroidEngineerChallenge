package com.dawoud.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dawoud.data.cache.entity.MovieEntity


@Database(
    entities = [MovieEntity::class], version = 1, exportSchema = false
)
abstract class RoomDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME: String = "general_database"
    }
}