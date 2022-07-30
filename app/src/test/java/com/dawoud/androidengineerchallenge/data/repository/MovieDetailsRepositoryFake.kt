package com.dawoud.androidengineerchallenge.data.repository

import com.dawoud.androidengineerchallenge.data.FakeData
import com.dawoud.data.network.dto.GeneralCreditsDto
import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.data.network.dto.MovieDto
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.repository.MovieDetailsRepository
import com.dawoud.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import org.junit.Assert.*

import org.junit.Test
import retrofit2.Response

class MovieDetailsRepositoryFake : MovieDetailsRepository {
    private val movieList = ArrayList<MovieModel>()
    init {
        for (i in 0..5)
            movieList.add(FakeData.returnFakeMovieModel())
    }
    override suspend fun getMovie(id: Int): Response<MovieDto> {
        if (id!=-1)
            return Response.success(FakeData.returnFakeMovieDto())
        else
            return  Response.error(101, ResponseBody.create(null,"as"))
    }


    override suspend fun getSimilarMovies(id: Int): Response<GeneralMovieDto> {
        if (id==1)
         return   Response.success(FakeData.returnFakeGenerlMoviesDto())
        else
         return   Response.success(GeneralMovieDto(1, emptyList(),1,1))
    }

    override suspend fun getMovieCredits(id: Int): Response<GeneralCreditsDto> {
        return Response.success(FakeData.returnFakeGenerlCreditsDto())
    }
}