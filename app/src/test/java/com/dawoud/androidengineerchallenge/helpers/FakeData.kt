package com.dawoud.androidengineerchallenge.helpers

import com.dawoud.domain.model.CastModel
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel

object FakeData {
    fun returnFakeMovieModel():MovieModel{
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
            ""
        )
    }
    fun returnFakeCastModel(): CastModel{
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
    fun returnFakeGenerlCreditsModel(): GenerlCreditsModel {
        return  GenerlCreditsModel(
            id = 0,
            cast = listOf(returnFakeCastModel()  , returnFakeCastModel())
        )
    }
    fun returnFakeMovieList():List<MovieModel>{
        return listOf(returnFakeMovieModel() , returnFakeMovieModel())
    }
}