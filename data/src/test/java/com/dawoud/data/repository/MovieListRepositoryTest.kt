package com.dawoud.data.repository

import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.helpers.FakeData
import com.dawoud.data.helpers.fakeRepository.MovieListRepositoryFake
import com.dawoud.data.network.calls.PopularMovieCall
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

class MovieListRepositoryTest {

    private val repository = MovieListRepositoryFake()

    @Test
    fun getAllMovie() = runBlocking {
        val movieList = ArrayList<MovieModel>()
        for (i in 1..5) {
            movieList.add(FakeData.returnFakeMovieModel())
        }
        repository.getAllMovies(1).collect{
            when(it){
                is DataState.Success -> {
                    Assert.assertEquals(it.data, movieList)
                    Assert.assertNotEquals(it.data, null)
                }
            }
        }

    }

}