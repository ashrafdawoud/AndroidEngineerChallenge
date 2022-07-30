package com.dawoud.data.repository

import com.dawoud.data.cache.dao.CreditsDao
import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.cache.mapper.toModel
import com.dawoud.data.cache.mapper.tomodel
import com.dawoud.data.network.calls.MovieDetailsCalls
import com.dawoud.data.network.dto.GeneralCreditsDto
import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.data.network.dto.MovieDto
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.utils.Constant
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieDetailsRepositoryImp constructor(
    private  val movieDetailsCalls: MovieDetailsCalls,
    private val popularMoviesDao: PopularMoviesDao,
    private val creditsDao: CreditsDao
) : MovieDetailsRepository {
    override suspend fun getMovie(id: Int): Response<MovieDto> =
        movieDetailsCalls.getMovieDetails(Constant.apiKey , id.toString())
    override suspend fun getSimilarMovies(id: Int): Response<GeneralMovieDto> =
        movieDetailsCalls.getSimilarMovies(Constant.apiKey , id.toString())
    override suspend fun getMovieCredits(id: Int): Response<GeneralCreditsDto> =
        movieDetailsCalls.getMovieCredits(Constant.apiKey , id.toString())
}