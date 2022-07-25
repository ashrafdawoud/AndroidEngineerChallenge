package com.dawoud.data.repository

import android.util.Log
import com.dawoud.data.cache.dao.PopularMoviesDao
import com.dawoud.data.cache.mapper.toListEntity
import com.dawoud.data.cache.mapper.toListModel
import com.dawoud.data.network.calls.PopularMovieCall
import com.dawoud.data.network.mapper.toListModel
import com.dawoud.data.network.mapper.toModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.Constant
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieListRepositoryImp constructor(
    private  val popularMovieCall: PopularMovieCall ,
    private val popularMoviesDao: PopularMoviesDao
) : MovieListRepository {
    override suspend fun getAllMovies(page: Int): Flow<DataState<List<MovieModel>>> = flow{
        emit(DataState.Loading)
        try {
            val popularMoviesDtoList = popularMovieCall.getPopularMovies(Constant.apiKey, Constant.language , page)
            Log.e("asasasa",popularMoviesDtoList.toString())
            val popularMoviesEntityList = popularMoviesDtoList.toModel().results.toListEntity()
            for (item in popularMoviesEntityList){
                popularMoviesDao.insert(item)
            }
            emit(DataState.Success(popularMoviesDao.getAll().toListModel()))
        }catch (e: Exception){
            emit(DataState.Error(e ,popularMoviesDao.getAll().toListModel()))
        }
    }

    override suspend fun searchForMovies(query: String): Flow<DataState<List<MovieModel>>> = flow{
        emit(DataState.Loading)
        try {
            val moviesResult = popularMovieCall.searchForMovie(Constant.apiKey , query)
            emit(DataState.Success(moviesResult.results.toListModel()))
        }catch (e:Exception){
            emit(DataState.Error(e , emptyList<MovieModel>()))
        }
    }
}