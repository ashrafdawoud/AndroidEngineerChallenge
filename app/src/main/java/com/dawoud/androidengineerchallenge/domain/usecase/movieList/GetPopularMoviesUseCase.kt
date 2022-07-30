package com.dawoud.domain.usecase.movieList

import android.util.Log
import com.dawoud.data.cache.mapper.toEntity
import com.dawoud.data.cache.mapper.toListModel
import com.dawoud.data.network.mapper.toListModel
import com.dawoud.data.network.mapper.toModel
import com.dawoud.data.network.mapper.tomodel
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private  val repository: MovieListRepository
) {
    suspend fun invok(page: Int): Flow<Resource<List<MovieModel>>> = flow {
        emit(Resource.Loading)
        try {
            val response = repository.getAllMovies(page)
            if (response.isSuccessful) {
                response.body()?.let {
                    repository.deleteTable()
                    for (item in it.results)
                        repository.insertMoviesCache(item.toModel().toEntity())
                    emit(Resource.Success(repository.getAllMoviesCache().toListModel()))
                }
            }
            emit(Resource.Error("${response.code()} ${response.message()}" , repository.getAllMoviesCache().toListModel()))
        } catch (e: Exception) {
            emit(Resource.Error(
                e.message ?: e.toString() ,
                repository.getAllMoviesCache().toListModel()))
        }
    }
}