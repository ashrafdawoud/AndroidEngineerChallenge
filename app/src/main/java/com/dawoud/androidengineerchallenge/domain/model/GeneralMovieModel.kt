package com.dawoud.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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
    val title:String,
    val genre_ids:List<Int>,
    val vote_count:Int,
    val video:Boolean,
    val vote_average:Double,
)
