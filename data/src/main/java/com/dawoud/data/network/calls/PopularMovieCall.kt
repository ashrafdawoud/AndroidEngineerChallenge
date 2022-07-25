package com.dawoud.data.network.calls

import com.dawoud.data.network.dto.GeneralMovieDto
import com.google.gson.JsonPrimitive
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PopularMovieCall {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ):GeneralMovieDto
    @GET("search/movie")
    suspend fun searchForMovie(
        @Query("api_key") api_key: String,
        @Query("query") query:String
    ):GeneralMovieDto
}