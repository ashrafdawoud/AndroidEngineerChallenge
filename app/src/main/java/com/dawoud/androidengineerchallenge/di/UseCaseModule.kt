package com.dawoud.androidengineerchallenge.di

import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.network.calls.PopularMovieCall
import com.dawoud.data.repository.MovieListRepositoryImp
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.usecase.GetPopularMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideMovieListUseCase(
       movieListRepository: MovieListRepository
    ): GetPopularMovies {
        return GetPopularMovies(movieListRepository)
    }
    @Singleton
    @Provides
    fun provideMovieListRepository(
        popularMovieCall: PopularMovieCall,
        popularMoviesDao: PopularMoviesDao,
    ): MovieListRepository {
        return MovieListRepositoryImp(popularMovieCall ,popularMoviesDao)
    }
}