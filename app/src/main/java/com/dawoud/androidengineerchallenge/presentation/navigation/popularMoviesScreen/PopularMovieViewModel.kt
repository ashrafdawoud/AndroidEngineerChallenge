package com.dawoud.androidengineerchallenge.presentation.navigation.popularMoviesScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawoud.domain.usecase.GetPopularMovies
import com.dawoud.domain.utils.DataState
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class PopularMovieViewModel @Inject constructor(
    private  val getPopularMovies: GetPopularMovies,
):ViewModel() {

    fun getPopularMovies(page:Int){
        viewModelScope.launch {
            getPopularMovies.invok(page).onEach{
                when(it){
                    is DataState.Success ->{
                        Log.e("data" , it.data.toString() )
                    }
                    is DataState.Error ->{
                        Log.e("data" , it.exception.toString() )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}