package com.dawoud.domain.usecase.movieDetails

import com.dawoud.domain.repository.MovieDetailsRepository

class GetMovieUseCase (
    private  val movieDetailsRepository: MovieDetailsRepository
        ){
    suspend fun invoke(id:Int) = movieDetailsRepository.getMovie(id)
}