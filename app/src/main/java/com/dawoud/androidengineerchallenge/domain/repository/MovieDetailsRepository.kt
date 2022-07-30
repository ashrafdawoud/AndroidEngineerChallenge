package com.dawoud.domain.repository

import com.dawoud.data.network.dto.GeneralCreditsDto
import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.data.network.dto.MovieDto
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieDetailsRepository {
    suspend fun getMovie(id:Int) : Response<MovieDto>
    suspend fun getSimilarMovies(id:Int) : Response<GeneralMovieDto>
    suspend fun getMovieCredits(id:Int) : Response<GeneralCreditsDto>
}