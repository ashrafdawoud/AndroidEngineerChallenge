package com.dawoud.androidengineerchallenge.presentation.navigation.movieDetailsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawoud.domain.model.GenerlCreditsModel
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.usecase.movieDetails.GetMovieCreditsUseCase
import com.dawoud.domain.usecase.movieDetails.GetMovieUseCase
import com.dawoud.domain.usecase.movieDetails.GetSimilarMoviesUseCase
import com.dawoud.domain.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor (
    private val getMovieUseCase: GetMovieUseCase,
    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase,
    private val getMovieCreditsUseCase: GetMovieCreditsUseCase
    ) :ViewModel(){
    val _movieDetailsDataSet: MutableLiveData<DataState<MovieModel>> = MutableLiveData()
    val movieDetailsDataSet: LiveData<DataState<MovieModel>>
        get() = _movieDetailsDataSet
    val _similarMovieDataSet: MutableLiveData<DataState<List<MovieModel>>> = MutableLiveData()
    val similarMovieDataSet: LiveData<DataState<List<MovieModel>>>
        get() = _similarMovieDataSet
    val _MovieCridetsDataSet: MutableLiveData<DataState<GenerlCreditsModel>> = MutableLiveData()
    val MovieCridetsDataSet: LiveData<DataState<GenerlCreditsModel>>
        get() = _MovieCridetsDataSet
    fun getMovieDetails(id:Int){
        viewModelScope.launch {
            getMovieUseCase.invoke(id)
                .onEach {
                    _movieDetailsDataSet.value = it
                }.launchIn(viewModelScope)
        }
    }
    fun getSimilarMoviesUseCase(id:Int){
        viewModelScope.launch {
            getSimilarMoviesUseCase.invoke(id)
                .onEach {
                    _similarMovieDataSet.value = it
                }.launchIn(viewModelScope)
        }
    }
    fun getMovieCreditsUseCase(id:Int){
        viewModelScope.launch {
            getMovieCreditsUseCase.invoke(id)
                .onEach {
                    _MovieCridetsDataSet.value = it
                }.launchIn(viewModelScope)
        }
    }
}