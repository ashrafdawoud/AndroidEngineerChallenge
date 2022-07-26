package com.dawoud.androidengineerchallenge.helpers.fakeMovieListUseCase

import com.dawoud.androidengineerchallenge.helpers.FakeData
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularMovieUseCaseFake {
    suspend fun invok(page:Int): Flow<DataState<List<MovieModel>>> = flow{
        emit( DataState.Success(FakeData.returnFakeMovieList()))
    }
}