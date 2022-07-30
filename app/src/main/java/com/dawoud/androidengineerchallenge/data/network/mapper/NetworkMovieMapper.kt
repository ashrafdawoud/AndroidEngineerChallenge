package com.dawoud.data.network.mapper

import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.data.network.dto.MovieDto
import com.dawoud.domain.model.GeneralMovieModel
import com.dawoud.domain.model.MovieModel

fun GeneralMovieDto.toModel():GeneralMovieModel{
    return GeneralMovieModel(
        page = page,
        results = results.toListModel()
    )
}

fun List<MovieDto>.toListModel():List<MovieModel>{
    return this.map { it.toModel() }
}

fun MovieDto.toModel():MovieModel{
    return MovieModel(
        id = id,
        adult = adult,
        backdrop_path = backdrop_path,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        genre_ids = genre_ids,
        vote_count = vote_count,
        video = video,
        vote_average = vote_average
    )
}