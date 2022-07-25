package com.dawoud.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dawoud.data.cache.entity.MovieEntity

@Dao
interface PopularMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: MovieEntity): Long

    @Query("SELECT * From PopularMovieTable ORDER BY id DESC")
    suspend fun getAll(): List<MovieEntity>
    @Query("SELECT * From PopularMovieTable WHERE id=:id LIMIT 1")
    suspend fun getMovie(id:Int): MovieEntity

    @Query("DELETE From PopularMovieTable")
    suspend fun delete_table()
}