package com.dawoud.androidengineerchallenge.presentation.navigation.movieDetailsScreen

import com.dawoud.androidengineerchallenge.data.FakeData
import com.dawoud.androidengineerchallenge.data.repository.MovieDetailsRepositoryFake
import com.dawoud.domain.usecase.movieDetails.GetMovieCreditsUseCase
import com.dawoud.domain.usecase.movieDetails.GetMovieUseCase
import com.dawoud.domain.usecase.movieDetails.GetSimilarMoviesUseCase
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * getMovie()
 *      1- if id != -1 return data with sucsess
 *      2- if id == -1 return error
 * getSimilarMovies()
 *      1- if id ==1 return data
 *      2- if id != 1 return empty list
 *getMovieCredits()
 *      1- always return success with data */
class MovieDetailsViewModelTest {
    private lateinit var getMovieUseCase: GetMovieUseCase
    private lateinit var getSimilarMoviesUseCase: GetSimilarMoviesUseCase
    private lateinit var getMovieCreditsUseCase: GetMovieCreditsUseCase
    private  lateinit var repository : MovieDetailsRepositoryFake

    @Before
    fun setUp(){
        repository = MovieDetailsRepositoryFake()
        getMovieUseCase= GetMovieUseCase(repository)
        getSimilarMoviesUseCase= GetSimilarMoviesUseCase(repository)
        getMovieCreditsUseCase= GetMovieCreditsUseCase(repository)
    }

    @Test
    fun `getMovie() with id not equal -1 `() = runBlocking{
        getMovieUseCase.invoke(1).collect{
            when(it){
                is Resource.Success ->{
                    assertEquals(it.data , FakeData.returnFakeMovieModel())
                }
            }
        }
    }
    @Test
    fun `getMovie() with id  equal -1 `() = runBlocking{
        getMovieUseCase.invoke(-1).collect{
            when(it){
                is Resource.Error ->{
                    assertEquals(it.data , null)
                }
            }
        }
    }
    @Test
    fun `getSimilarMovies() with id  equal 1 `() = runBlocking{
        getSimilarMoviesUseCase.invoke(1).collect{
            when(it){
                is Resource.Success ->{
                    assertTrue(it.data.isNotEmpty())
                }
            }
        }
    }
    @Test
    fun `getSimilarMovies() with id  not equal 1 `() = runBlocking{
        getSimilarMoviesUseCase.invoke(10).collect{
            when(it){
                is Resource.Success ->{
                    assertTrue(it.data.isEmpty())
                }
            }
        }
    }
    @Test
    fun `getMovieCredits() with any data `() = runBlocking{
        getMovieCreditsUseCase.invoke(1).collect{
            when(it){
                is Resource.Success ->{
                    assertTrue(it.data.cast.isNotEmpty())
                }
            }
        }
    }

}