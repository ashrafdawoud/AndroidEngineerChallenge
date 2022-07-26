package com.dawoud.data.helpers.fakeRepository

import com.dawoud.data.helpers.FakeData
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieListRepositoryFake : MovieListRepository {
    val movieList = ArrayList<MovieModel>()
    init {
        for (i in 1..5) {
            movieList.add(FakeData.returnFakeMovieModel())
        }
    }
    override suspend fun getAllMovies(page: Int): Flow<DataState<List<MovieModel>>> = flow {
        //add data to list to work as data from network
        emit(DataState.Success(movieList))
    }

    override suspend fun searchForMovies(query: String): Flow<DataState<List<MovieModel>>> = flow {
        emit(DataState.Success(movieList))
    }
}