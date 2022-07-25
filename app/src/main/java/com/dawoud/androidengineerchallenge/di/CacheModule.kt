package com.dawoud.androidengineerchallenge.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dawoud.data.cache.MoviesRoomDataBase
import com.dawoud.data.cache.dao.CreditsDao

import com.dawoud.data.cache.dao.PopularMoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CacheModule {
    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): MoviesRoomDataBase {
        return Room.databaseBuilder(context, MoviesRoomDataBase::class.java, MoviesRoomDataBase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDAO(roomDatabase: MoviesRoomDataBase): PopularMoviesDao {
        return roomDatabase.moviesDao()
    }
    @Singleton
    @Provides
    fun provideCreditsDao(roomDatabase: MoviesRoomDataBase): CreditsDao {
        return roomDatabase.creditsDao()
    }
}