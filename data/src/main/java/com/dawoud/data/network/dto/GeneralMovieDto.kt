package com.dawoud.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Nullable

data class GeneralMovieDto(
    @SerializedName("page")
    val page : Int ,
    @SerializedName("results")
    val results : List<MovieDto>,
    @SerializedName("total_results")
    val total_results: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
)
data class MovieDto(
    @SerializedName("id")
    val id : Int,
    @SerializedName("adult")
    val adult : Boolean,
    @SerializedName("backdrop_path")
    @Nullable
    val backdrop_path : String?,
    @SerializedName("original_language")
    val original_language :String,
    @SerializedName("original_title")
    val original_title :String,
    @SerializedName("overview")
    val overview :String,
    @SerializedName("popularity")
    val popularity :Double,
    @SerializedName("poster_path")
    @Nullable
    val poster_path :String?,
    @SerializedName("release_date")
    val release_date :String,
    @SerializedName("title")
    val title :String,
    @SerializedName("genre_ids")
    val genre_ids :List<Int>,
    @SerializedName("vote_count")
    val vote_count :Int,
    @SerializedName("video")
    val video :Boolean,
    @SerializedName("vote_average")
    val vote_average :Double,
)
