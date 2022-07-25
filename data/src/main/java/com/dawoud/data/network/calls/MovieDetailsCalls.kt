package com.dawoud.data.network.calls

import com.dawoud.data.network.dto.GeneralCreditsDto
import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.data.network.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsCalls {
    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Query("api_key") api_key: String,
        @Path("id") id : String
    ): MovieDto
    @GET("movie/{id}/similar")
    suspend fun getSimilarMovies(
        @Query("api_key") api_key: String,
        @Path("id") id : String
    ): GeneralMovieDto
    @GET("movie/{id}/credits")
    suspend fun getMovieCredits(
        @Query("api_key") api_key: String,
        @Path("id") id : String
    ): GeneralCreditsDto
}