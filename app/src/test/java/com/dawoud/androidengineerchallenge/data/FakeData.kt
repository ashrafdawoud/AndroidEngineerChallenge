package com.dawoud.androidengineerchallenge.data

import com.dawoud.data.cache.entity.MovieEntity
import com.dawoud.data.network.dto.CastDto
import com.dawoud.data.network.dto.GeneralCreditsDto
import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.data.network.dto.MovieDto
import com.dawoud.domain.model.CastModel
import com.dawoud.domain.model.MovieModel

object FakeData {
    fun returnFakeMovieModel(): MovieModel {
        return MovieModel(
            0,
            true,
            "",
            "",
            "",
            "",
            0.0,
            "",
            "",
            "",
            listOf(1,2,3),
            123,
            true,
            1.1
        )
    }
    fun returnFakeMovieDto(): MovieDto {
        return MovieDto(
            0,
            true,
            "",
            "",
            "",
            "",
            0.0,
            "",
            "",
            "",
            listOf(1,2,3),
            123,
            true,
            1.1
        )
    }
    fun returnFakeMovieEntity(): MovieEntity {
        return MovieEntity(
            0,
            true,
            "",
            "",
            "",
            "",
            0.0,
            "",
            "",
            "",
            listOf(1,2,3),
            123,
            true,
            1.1
        )
    }
    fun returnFakeCastModel(): CastModel {
        return CastModel(
            false,
            null,
            0,
            "",
            "",
            "",
            0,
            null,
            0,
            "",
            "",
            0,

            )
    }
    fun returnFakeCastDto(): CastDto {
        return CastDto(
            false,
            null,
            0,
            "",
            "",
            "",
            0,
            null,
            0,
            "",
            "",
            0,

            )
    }
    fun returnFakeGenerlCreditsDto(): GeneralCreditsDto {
        return  GeneralCreditsDto(
            id = 0,
            cast = listOf(returnFakeCastDto()  , returnFakeCastDto()),
        )
    }
    fun returnFakeGenerlMoviesDto(): GeneralMovieDto {
        return  GeneralMovieDto(
            page = 0,
            results = listOf(returnFakeMovieDto()  , returnFakeMovieDto()),
            total_pages = 12,
            total_results = 12

        )
    }
}