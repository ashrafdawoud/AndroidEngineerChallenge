package com.dawoud.androidengineerchallenge.data.repository

import com.dawoud.androidengineerchallenge.data.FakeData
import com.dawoud.data.cache.entity.MovieEntity
import com.dawoud.data.network.dto.GeneralMovieDto
import com.dawoud.data.network.dto.MovieDto
import com.dawoud.domain.repository.MovieListRepository
import com.dawoud.domain.utils.Resource
import okhttp3.ResponseBody
import retrofit2.Response

class MovieListRepositoryFake : MovieListRepository {
    private val movieList = ArrayList<MovieDto>()
    private val movieListCache = ArrayList<MovieEntity>()

    init {
        for (i in 1..5) {
            movieList.add(FakeData.returnFakeMovieDto())
            movieListCache.add(FakeData.returnFakeMovieEntity())
        }
    }

    override suspend fun getAllMovies(page: Int): Response<GeneralMovieDto> {
        if (page!=-1)
            return Response.success(GeneralMovieDto(1,movieList,1,1))
        else if (page == 1)
            return Response.success(GeneralMovieDto(1, emptyList(),1,1))
        else
           return  Response.error(101, ResponseBody.create(null,"wrong page"))

    }

    override suspend fun getAllMoviesCache(): List<MovieEntity> {
        return movieListCache
    }

    override suspend fun insertMoviesCache(movieEntity: MovieEntity): Long {
        movieListCache.add(movieEntity)
        return 1
    }

    override suspend fun deleteTable() {
        movieListCache.clear()
    }

    override suspend fun searchForMovies(query: String): Response<GeneralMovieDto> {
        if (query.equals("")) {
           return Response.success(GeneralMovieDto(1, emptyList(),1,1))
        } else {
            if (query.equals("Marvel"))
                return Response.success(GeneralMovieDto(1, movieList,1,1))

            else
                return Response.success(GeneralMovieDto(1, emptyList(),1,1))

        }
    }
}