package com.dawoud.domain.usecase.movieDetails

import com.dawoud.data.network.mapper.toListModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSimilarMoviesUseCase (
    private val movieDetailsRepository: MovieDetailsRepository
        ) {
    suspend fun invoke(id: Int): Flow<Resource<List<MovieModel>>> =  flow {

        emit(Resource.Loading)
        try {
            val response = movieDetailsRepository.getSimilarMovies(id)
            if (response.isSuccessful)
                response.body()?.let {
                    emit(Resource.Success(it.results.toListModel()))
                }
            emit(Resource.Error("${response.code()} ${response.message()}"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: e.toString()))
        }
    }
}