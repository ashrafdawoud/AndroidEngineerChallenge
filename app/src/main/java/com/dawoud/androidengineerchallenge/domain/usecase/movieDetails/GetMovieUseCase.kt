package com.dawoud.domain.usecase.movieDetails

import com.dawoud.data.network.mapper.toModel
import com.dawoud.data.network.mapper.tomodel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private  val movieDetailsRepository: MovieDetailsRepository
        ) {
    suspend fun invoke(id: Int): Flow<Resource<MovieModel>> = flow {
        emit(Resource.Loading)
        try {
            val response = movieDetailsRepository.getMovie(id)
            if (response.isSuccessful)
                response.body()?.let {
                    emit(Resource.Success(it.toModel()))
                }
            emit(Resource.Error("${response.code()} ${response.message()}"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: e.toString()))
        }
    }
}