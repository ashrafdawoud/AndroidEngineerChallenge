package com.dawoud.data.helpers.fakeRepository

import com.dawoud.data.helpers.FakeData
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieDetailsRepositoryFake : MovieDetailsRepository {
    private val movieList = ArrayList<MovieModel>()
    init {
        for (i in 0..5)
            movieList.add(FakeData.returnFakeMovieModel())
    }
    override suspend fun getMovie(id: Int): Flow<DataState<MovieModel>> = flow{
        emit(DataState.Success(FakeData.returnFakeMovieModel()))
    }

    override suspend fun getSimilarMovies(id: Int): Flow<DataState<List<MovieModel>>> = flow{
       if (id==1)
            emit(DataState.Success(movieList))
        else
            emit(DataState.Success(emptyList()))
    }

    override suspend fun getMovieCredits(id: Int): Flow<DataState<GenerlCreditsModel>> =flow{
        emit(DataState.Success(FakeData.returnFakeGenerlCreditsModel()))
    }
}