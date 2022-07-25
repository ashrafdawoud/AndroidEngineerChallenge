package com.dawoud.androidengineerchallenge.presentation.navigation.popularMoviesScreen

import androidx.lifecycle.*
import com.dawoud.domain.model.MovieModel
import com.dawoud.domain.usecase.movieList.GetPopularMoviesUseCase
import com.dawoud.domain.usecase.movieList.SearchForMovieUseCase
import com.dawoud.domain.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class PopularMovieViewModel @Inject constructor(
    private  val getPopularMovies: GetPopularMoviesUseCase,
    private val searchForMovie: SearchForMovieUseCase
):ViewModel() {

    val _popularMovieDataSet: MutableLiveData<DataState<List<MovieModel>>> = MutableLiveData()
    val popularMovieDataSet: LiveData<DataState<List<MovieModel>>>
        get() = _popularMovieDataSet
    val _searchMovieDataSet: MutableLiveData<DataState<List<MovieModel>>> = MutableLiveData()
    val searchMovieDataSet: LiveData<DataState<List<MovieModel>>>
        get() = _searchMovieDataSet

    fun getPopularMovies(page:Int){
        viewModelScope.launch {
            getPopularMovies.invok(page).onEach{
                _popularMovieDataSet.value = it
            }.launchIn(viewModelScope)
        }
    }
    fun searchForMovie(query:String){
        viewModelScope.launch {
            searchForMovie.invoke(query).onEach {
                _searchMovieDataSet.value = it
            }.launchIn(viewModelScope)
        }
    }
}