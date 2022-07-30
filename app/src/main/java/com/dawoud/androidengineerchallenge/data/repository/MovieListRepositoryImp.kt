package com.dawoud.data.repository

import android.util.Log
import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.cache.entity.MovieEntity
import com.dawoud.data.cache.mapper.toListModel
import com.dawoud.data.network.calls.PopularMovieCall
import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.Constant
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieListRepositoryImp constructor(
    private  val popularMovieCall: PopularMovieCall ,
    private val popularMoviesDao: PopularMoviesDao
) : MovieListRepository {
    override suspend fun getAllMovies(page: Int): Response<GeneralMovieDto> =
        popularMovieCall.getPopularMovies(Constant.apiKey, Constant.language , page)
    override suspend fun getAllMoviesCache(): List<MovieEntity> =
        popularMoviesDao.getAll()
    override suspend fun insertMoviesCache(movieEntity: MovieEntity): Long =
        popularMoviesDao.insert(movieEntity)
    override suspend fun deleteTable() =
        popularMoviesDao.delete_table()
    override suspend fun searchForMovies(query: String): Response<GeneralMovieDto> =
        popularMovieCall.searchForMovie(Constant.apiKey , query)
}