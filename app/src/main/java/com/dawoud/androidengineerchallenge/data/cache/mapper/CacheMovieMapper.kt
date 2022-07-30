package com.dawoud.data.cache.mapper

import com.dawoud.data.cache.entity.MovieEntity
import com.dawoud.domain.model.MovieModel


fun List<MovieEntity>.toListModel(): List<MovieModel> {
    return this.map { it.toModel() }
}

fun MovieEntity.toModel(): MovieModel {
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

fun List<MovieModel>.toListEntity(): List<MovieEntity> {
    return this.map { it.toEntity() }
}

fun MovieModel.toEntity(): MovieEntity {
    return MovieEntity(
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