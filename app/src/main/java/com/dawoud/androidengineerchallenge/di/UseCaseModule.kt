package com.dawoud.androidengineerchallenge.di

import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.usecase.movieDetails.GetMovieCreditsUseCase
import com.dawoud.domain.usecase.movieDetails.GetMovieUseCase
import com.dawoud.domain.usecase.movieDetails.GetSimilarMoviesUseCase
import com.dawoud.domain.usecase.movieList.GetPopularMoviesUseCase
import com.dawoud.domain.usecase.movieList.SearchForMovieUseCase
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
    fun provideGetPopularMovieUseCase(
       movieListRepository: MovieListRepository
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(movieListRepository)
    }
    @Singleton
    @Provides
    fun provideSerachForMovieUseCase(
       movieListRepository: MovieListRepository
    ): SearchForMovieUseCase {
        return SearchForMovieUseCase(movieListRepository)
    }
    @Singleton
    @Provides
    fun providegetMovieDetailsUseCase(
        movieDetailsRepository: MovieDetailsRepository
    ): GetMovieUseCase {
        return GetMovieUseCase(movieDetailsRepository)
    }
    @Singleton
    @Provides
    fun providegetSimilarMovieUseCase(
        movieDetailsRepository: MovieDetailsRepository
    ): GetSimilarMoviesUseCase {
        return GetSimilarMoviesUseCase(movieDetailsRepository)
    }
    @Singleton
    @Provides
    fun providegetMovieCreditsUseCase(
        movieDetailsRepository: MovieDetailsRepository
    ): GetMovieCreditsUseCase {
        return GetMovieCreditsUseCase(movieDetailsRepository)
    }
}