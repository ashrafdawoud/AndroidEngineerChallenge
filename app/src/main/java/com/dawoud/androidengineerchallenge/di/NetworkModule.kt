package com.dawoud.androidengineerchallenge.di

import com.dawoud.data.network.calls.MovieDetailsCalls
import com.dawoud.data.network.calls.PopularMovieCall
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.internal.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        val okHttpClient: OkHttpClient =OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://developers.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(ScalarsConverterFactory.create())

    }
    @Singleton
    @Provides
    fun providePopularMovieCall(retrofit: Retrofit.Builder): PopularMovieCall {
        return retrofit
            .build()
            .create(PopularMovieCall::class.java)
    }
    @Singleton
    @Provides
    fun provideMoviewDetailsCall(retrofit: Retrofit.Builder): MovieDetailsCalls {
        return retrofit
            .build()
            .create(MovieDetailsCalls::class.java)
    }
}