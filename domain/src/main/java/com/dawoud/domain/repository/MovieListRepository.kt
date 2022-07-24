package com.dawoud.domain.repository

import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getAllMovies (page:Int) : Flow<DataState<List<MovieModel>>>
    suspend fun searchForMovies(query:String) : Flow<DataState<List<MovieModel>>>
}