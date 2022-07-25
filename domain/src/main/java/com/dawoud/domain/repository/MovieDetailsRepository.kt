package com.dawoud.domain.repository

import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow

interface MovieDetailsRepository {
    suspend fun getMovie(id:Int) : Flow<DataState<MovieModel>>
    suspend fun getSimilarMovies(id:Int) : Flow<DataState<List<MovieModel>>>
    suspend fun getMovieCredits(id:Int) : Flow<DataState<GenerlCreditsModel>>
}