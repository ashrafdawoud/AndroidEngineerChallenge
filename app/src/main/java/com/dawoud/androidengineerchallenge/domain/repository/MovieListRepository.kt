package com.dawoud.domain.repository

import com.dawoud.data.cache.entity.MovieEntity
import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieListRepository {
    suspend fun getAllMovies (page:Int) : Response<GeneralMovieDto>
    suspend fun getAllMoviesCache () : List<MovieEntity>
    suspend fun insertMoviesCache (movieEntity: MovieEntity ):Long
    suspend fun deleteTable ()
    suspend fun searchForMovies(query:String) : Response<GeneralMovieDto>
}