package com.dawoud.data.helpers

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
}