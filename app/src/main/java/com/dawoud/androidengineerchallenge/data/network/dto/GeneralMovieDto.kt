package com.dawoud.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Nullable

data class GeneralMovieDto(
    @SerializedName("page")
    @Expose
    val page : Int ,
    @SerializedName("results")
    @Expose
    val results : List<MovieDto>,
    @SerializedName("total_results")
    @Expose
    val total_results: Int,
    @SerializedName("total_pages")
    @Expose
    val total_pages: Int,
)
data class MovieDto(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("adult")
    @Expose
    val adult: Boolean,
    @SerializedName("backdrop_path")
    @Expose
    @Nullable
    val backdrop_path: String?,
    @SerializedName("original_language")
    @Expose
    val original_language:String,
    @SerializedName("original_title")
    @Expose
    val original_title:String,
    @SerializedName("overview")
    @Expose
    val overview:String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    @Expose
    @Nullable
    val poster_path:String?,
    @SerializedName("release_date")
    @Expose
    val release_date:String,
    @SerializedName("title")
    @Expose
    val title:String,
    @SerializedName("genre_ids")
    @Expose
    val genre_ids:List<Int>,
    @SerializedName("vote_count")
    @Expose
    val vote_count:Int,
    @SerializedName("video")
    @Expose
    val video:Boolean,
    @SerializedName("vote_average")
    @Expose
    val vote_average:Double,
)
