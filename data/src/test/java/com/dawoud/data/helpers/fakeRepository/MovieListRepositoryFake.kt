package com.dawoud.data.helpers.fakeRepository

import com.dawoud.data.helpers.FakeData
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieListRepositoryFake : MovieListRepository {
    private val movieList = ArrayList<MovieModel>()

    init {
        for (i in 1..5) {
            movieList.add(FakeData.returnFakeMovieModel())
        }
    }

    override suspend fun getAllMovies(page: Int): Flow<DataState<List<MovieModel>>> = flow {
        //add data to list to work as data from network
        if (movieList.isNotEmpty())
            emit(DataState.Success(movieList))
        else
            emit(DataState.Success(emptyList()))
    }

    override suspend fun searchForMovies(query: String): Flow<DataState<List<MovieModel>>> = flow {
        if (query.equals("")) {
            emit(DataState.Success(emptyList()))
        } else {
            if (query.equals("Marvel"))
                emit(DataState.Success(movieList))
            else
                emit(DataState.Success(emptyList()))
        }
    }
}