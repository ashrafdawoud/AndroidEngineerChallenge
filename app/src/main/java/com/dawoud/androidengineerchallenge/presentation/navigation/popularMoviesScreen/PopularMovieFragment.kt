package com.dawoud.androidengineerchallenge.presentation.navigation.popularMoviesScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.dawoud.androidengineerchallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMovieFragment : Fragment() {
  val viewmodel : PopularMovieViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_popular_movie, container, false)
        viewmodel.getPopularMovies(1)
        val text = view.findViewById<TextView>(R.id.text)
        return view
    }

}