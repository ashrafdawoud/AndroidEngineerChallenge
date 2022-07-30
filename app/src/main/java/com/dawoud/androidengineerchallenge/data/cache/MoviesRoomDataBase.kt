package com.dawoud.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dawoud.data.cache.dao.CreditsDao
import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.cache.entity.CastConverters
import com.dawoud.data.cache.entity.GeneralCreditsEntity
import com.dawoud.data.cache.entity.Genre_idsConverters
import com.dawoud.data.cache.entity.MovieEntity


@Database(
    entities = [MovieEntity::class , GeneralCreditsEntity::class], version = 7, exportSchema = false
)
@TypeConverters(CastConverters::class , Genre_idsConverters::class)
abstract class MoviesRoomDataBase : RoomDatabase() {
    abstract fun moviesDao():PopularMoviesDao
    abstract fun creditsDao(): CreditsDao
    companion object {
        val DATABASE_NAME: String = "general_database"
    }
}