package com.dawoud.androidengineerchallenge.presentation.navigation.popularMoviesScreen

import com.dawoud.androidengineerchallenge.data.repository.MovieListRepositoryFake
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.usecase.movieList.GetPopularMoviesUseCase
import com.dawoud.domain.usecase.movieList.SearchForMovieUseCase
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * getPopularMovie()
 *      1- if page is -1 it will return empty movie list
 *      2- if page is any number not equal -1 it will return movie list
 *      3- if page is equal 0 it will return error with data from room
 *
 * searchForMovies()
 *      1- if query is equal "" will return sucess with empty list
 *      2- if query is equal "marvel" return return list with data
 *      3- else will return empty list*/
class PopularMovieViewModelTest {
    private lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase
    private lateinit var searchForMovieUseCase: SearchForMovieUseCase
    private lateinit var popularMovieViewModel: PopularMovieViewModel
    private val repository = MovieListRepositoryFake()

    @Before
    fun setUp() {
        getPopularMoviesUseCase = GetPopularMoviesUseCase(repository)
        searchForMovieUseCase = SearchForMovieUseCase(repository)
        popularMovieViewModel =
            PopularMovieViewModel(getPopularMoviesUseCase, searchForMovieUseCase)
    }

    @Test
    fun `get popular movie with page number equal -1 `() = runBlocking {
        val result = getPopularMoviesUseCase.invok(-1)
        result.collect {
            when (it) {
                is Resource.Success -> {
                    assertTrue(it.data.isEmpty())
                }
            }
        }
    }
    @Test
    fun `get popular movie with page number equal 1 `() = runBlocking {
        val result = getPopularMoviesUseCase.invok(1)
        result.collect {
            when (it) {
                is Resource.Success -> {
                    assertTrue(it.data.isNotEmpty())
                }
            }
        }
    }
    @Test
    fun `get popular movie with page number which return error `() = runBlocking {
        val result = getPopularMoviesUseCase.invok(0)
        result.collect {
            when (it) {
                is Resource.Error -> {
                    assertNotEquals(it.data , null)
                }
            }
        }
    }
    @Test
    fun `searchForMovies() with query equal "" `() = runBlocking{
        val result = searchForMovieUseCase.invoke("")
        result.collect{
            when(it){
                is Resource.Success ->{
                    assertTrue(it.data.isEmpty())
                }
            }
        }
    }
    @Test
    fun `searchForMovies() with query equal "Marvel" `() = runBlocking{
        val result = searchForMovieUseCase.invoke("Marvel")
        result.collect{
            when(it){
                is Resource.Success ->{
                    assertTrue(it.data.isNotEmpty())
                }
            }
        }
    }
    @Test
    fun `searchForMovies() with any value for query `() = runBlocking{
        val result = searchForMovieUseCase.invoke("Dawoud")
        result.collect{
            when(it){
                is Resource.Success ->{
                    assertTrue(it.data.isEmpty())
                }
            }
        }
    }

}