package com.dawoud.domain.usecase.movieDetails

import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.utils.DataState
import kotlinx.coroutines.flow.Flow

class GetMovieCreditsUseCase (
    private val movieDetailsRepository: MovieDetailsRepository
) {
    suspend fun invoke(id:Int) : Flow<DataState<GenerlCreditsModel>> = movieDetailsRepository.getMovieCredits(id)
}