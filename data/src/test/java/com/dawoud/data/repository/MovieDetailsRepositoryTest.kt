package com.dawoud.data.repository

import com.dawoud.data.helpers.FakeData
import com.dawoud.data.helpers.fakeRepository.MovieDetailsRepositoryFake
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieDetailsRepositoryTest {
    private val repository = MovieDetailsRepositoryFake()
    private val movieList = ArrayList<MovieModel>()
    @Before
    fun setUp(){
        for (i in 0..5)
            movieList.add(FakeData.returnFakeMovieModel())
    }
    @Test
    fun getMovie() = runBlocking{
        repository.getMovie(1).collect{
            when(it){
                is DataState.Success ->{
                    Assert.assertEquals(it.data , FakeData.returnFakeMovieModel())
                }
            }
        }
    }
    /**
     * 1- call getSimillarMovie() with id = 1 -> return MovieList
     * 2- call getSimillarMovie() with id !=1 -> return empty List*/
    @Test
    fun getSimillarMovie() = runBlocking{
        repository.getSimilarMovies(1).collect{
            when(it){
                is DataState.Success -> {
                    Assert.assertEquals(it.data , movieList)
                }
            }
        }
        repository.getSimilarMovies(0).collect{
            when(it){
                is DataState.Success -> {
                    Assert.assertTrue(it.data.isEmpty())
                }
            }
        }
    }
    @Test
    fun getMovieCredits()= runBlocking{
        repository.getMovieCredits(1).collect{
            when(it){
                is DataState.Success ->{
                    Assert.assertEquals(it.data,FakeData.returnFakeGenerlCreditsModel())
                }
            }
        }
    }
}