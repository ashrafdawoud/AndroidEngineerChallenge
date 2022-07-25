package com.dawoud.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dawoud.data.cache.entity.GeneralCreditsEntity
import com.dawoud.data.cache.entity.MovieEntity

@Dao
interface CreditsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: GeneralCreditsEntity): Long

    @Query("SELECT * From CreditsTable WHERE id=:id LIMIT 1")
    suspend fun getMovie(id:Int): GeneralCreditsEntity

    @Query("DELETE From CreditsTable")
    suspend fun delete_table()
}