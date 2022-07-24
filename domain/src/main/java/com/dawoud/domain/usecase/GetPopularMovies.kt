package com.dawoud.domain.usecase

import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularMovies  constructor(
    private  val movieListRepository: MovieListRepository
){
    suspend fun invok(page:Int):Flow<DataState<List<MovieModel>>> = movieListRepository.getAllMovies(page)
}