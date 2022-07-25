package com.dawoud.androidengineerchallenge.di

import com.dawoud.data.cache.dao.CreditsDao
import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.network.calls.MovieDetailsCalls
import com.dawoud.data.network.calls.PopularMovieCall
import com.dawoud.data.repository.MovieDetailsRepositoryImp
import com.dawoud.data.repository.MovieListRepositoryImp
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.repository.MovieListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieListRepository(
        popularMovieCall: PopularMovieCall,
        popularMoviesDao: PopularMoviesDao,
    ): MovieListRepository {
        return MovieListRepositoryImp(popularMovieCall ,popularMoviesDao)
    }
    @Singleton
    @Provides
    fun provideMovieDetailsRepository(
        movieDetailsCalls: MovieDetailsCalls,
        popularMoviesDao: PopularMoviesDao,
        creditsDao: CreditsDao
    ): MovieDetailsRepository {
        return MovieDetailsRepositoryImp(movieDetailsCalls ,popularMoviesDao , creditsDao)
    }
}