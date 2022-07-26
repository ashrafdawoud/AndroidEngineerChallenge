package com.dawoud.domain.model

data class GeneralMovieModel(
    val page : Int ,
    val results : List<MovieModel>
)
data class MovieModel(
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String?,
    val original_language:String,
    val original_title:String,
    val overview:String,
    val popularity: Double,
    val poster_path:String?,
    val release_date:String,
    val title:String
)
