package com.dawoud.domain.usecase.movieDetails

import com.dawoud.data.network.mapper.toModel
import com.dawoud.data.network.mapper.tomodel
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
) {
    suspend fun invoke(id:Int) : Flow<Resource<GenerlCreditsModel>> = flow {
        emit(Resource.Loading)
        try {
            val response = movieDetailsRepository.getMovieCredits(id)
            if (response.isSuccessful)
                response.body()?.let {
                    emit(Resource.Success(it.tomodel()))
                }
            emit(Resource.Error("${response.code()} ${response.message()}"))
        }catch (e:Exception){
            emit(Resource.Error(e.message ?:e.toString()))
        }
    }
}