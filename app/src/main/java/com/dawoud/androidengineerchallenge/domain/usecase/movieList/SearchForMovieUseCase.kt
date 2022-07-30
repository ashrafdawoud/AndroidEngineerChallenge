package com.dawoud.domain.usecase.movieList

import com.dawoud.data.network.mapper.toListModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchForMovieUseCase (
    private val repository: MovieListRepository
    ) {
    suspend fun invoke(query:String): Flow<Resource<List<MovieModel>>> = flow {
        emit(Resource.Loading)
        try {
            if (query.isNotEmpty()){
                val response = repository.searchForMovies(query)
                if (response.isSuccessful)
                    response.body()?.let {
                        emit(Resource.Success(it.results.toListModel()))
                    }
                emit(Resource.Error("${response.code()} ${response.message()}"))
            }else{
                emit(Resource.Error("Query shouldn't be empty"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: e.toString()))
        }
    }
}