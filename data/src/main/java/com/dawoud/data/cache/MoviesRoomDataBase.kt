package com.dawoud.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.cache.entity.MovieEntity


@Database(
    entities = [MovieEntity::class], version = 3, exportSchema = false
)
abstract class MoviesRoomDataBase : RoomDatabase() {
    abstract fun moviesDao():PopularMoviesDao
    companion object {
        val DATABASE_NAME: String = "general_database"
    }
}