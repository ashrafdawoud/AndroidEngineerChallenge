package com.dawoud.androidengineerchallenge.di

import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.network.calls.PopularMovieCall
import com.dawoud.data.repository.MovieListRepositoryImp
import com.dawoud.domain.repository.MovieListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

}