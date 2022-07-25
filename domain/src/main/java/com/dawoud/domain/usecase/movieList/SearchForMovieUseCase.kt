package com.dawoud.domain.usecase.movieList

import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchForMovieUseCase (
    private val repository: MovieListRepository
    ) {
    suspend fun invoke(query:String): Flow<DataState<List<MovieModel>>> = repository.searchForMovies(query)
}