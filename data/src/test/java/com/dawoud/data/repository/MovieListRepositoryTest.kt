package com.dawoud.data.repository

import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.helpers.FakeData
import com.dawoud.data.helpers.fakeRepository.MovieListRepositoryFake
import com.dawoud.data.network.calls.PopularMovieCall
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * 1- first test case getAllMovies should return MovieList
 * 2- second test case search for movie may return empty list and may not
 * 3- third test case empty search query should return empty list
 * */
class MovieListRepositoryTest {

    private val repository = MovieListRepositoryFake()
    val movieList = ArrayList<MovieModel>()

    @Before
    fun setUp(){
        for (i in 1..5) {
            movieList.add(FakeData.returnFakeMovieModel())
        }
    }
    @Test
    fun getAllMovie() = runBlocking {

        repository.getAllMovies(1).collect{
            when(it){
                is DataState.Success -> {
                    Assert.assertEquals(it.data, movieList)
                    Assert.assertNotEquals(it.data, null)
                }
            }
        }
    }
    @Test
    fun serachForMovie() = runBlocking {
       repository.searchForMovies("").collect{
           when(it){
               is DataState.Success ->{
                   Assert.assertTrue(it.data.isEmpty())
               }
           }
       }
        repository.searchForMovies("Marvel").collect{
           when(it){
               is DataState.Success ->{
                   Assert.assertEquals(it.data , movieList)
               }
           }
       }
        repository.searchForMovies("AAAA").collect{
           when(it){
               is DataState.Success ->{
                   Assert.assertTrue(it.data.isEmpty() )
               }
           }
       }
    }

}