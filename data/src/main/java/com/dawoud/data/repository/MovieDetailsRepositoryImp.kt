package com.dawoud.data.repository

import android.media.ExifInterface
import com.dawoud.data.cache.dao.CreditsDao
import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.cache.mapper.toEntity
import com.dawoud.data.cache.mapper.toModel
import com.dawoud.data.cache.mapper.tomodel
import com.dawoud.data.network.calls.MovieDetailsCalls
import com.dawoud.data.network.mapper.toListModel
import com.dawoud.data.network.mapper.toModel
import com.dawoud.data.network.mapper.tomodel
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.Constant
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieDetailsRepositoryImp constructor(
    private  val movieDetailsCalls: MovieDetailsCalls,
    private val popularMoviesDao: PopularMoviesDao,
    private val creditsDao: CreditsDao
) : MovieDetailsRepository {
    override suspend fun getMovie(id: Int): Flow<DataState<MovieModel>> =flow {
        emit(DataState.Loading)
        try {
            val movie = movieDetailsCalls.getMovieDetails(Constant.apiKey , id.toString())
            emit(DataState.Success(movie.toModel()))
        }catch (e:Exception){
            emit(DataState.Error(e ,popularMoviesDao.getMovie(id).toModel()))
        }
    }

    override suspend fun getSimilarMovies(id: Int): Flow<DataState<List<MovieModel>>> = flow{
        emit(DataState.Loading)
        try {
            val similarMovie = movieDetailsCalls.getSimilarMovies(Constant.apiKey , id.toString())
            emit(DataState.Success(similarMovie.results.toListModel()))
        }catch (e:Exception){
            emit(DataState.Error(e , null ))
        }
    }

    override suspend fun getMovieCredits(id: Int): Flow<DataState<GenerlCreditsModel>>  = flow{
        emit(DataState.Loading)
        try {
            val moviewCredits = movieDetailsCalls.getMovieCredits(Constant.apiKey , id.toString())
            creditsDao.insert(moviewCredits.tomodel().toEntity())
            emit(DataState.Success(creditsDao.getMovie(id).tomodel()))
        }catch (e:Exception){
            emit(DataState.Error(e , null ))
        }
    }
}