package com.proyecto.emovie.domain.movieDetail

import androidx.lifecycle.ViewModel
import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MovieDetail
import com.proyecto.emovie.domain.repositories.repository.MovieDetailRepository
import com.proyecto.emovie.infraestructure.network.response.MovieResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) : ViewModel() {

    private lateinit var movieDetailIntent: MovieDetailIntent
    private lateinit var movie: MovieDetail

    fun onMovieDetailIntent(movieDetailIntent: MovieDetailIntent) {
        this.movieDetailIntent = movieDetailIntent
    }

    fun loadMovieDetail(movie: Movie) {
        runBlocking { validateMovieDetailToDisplay(movie) }
    }

    private suspend fun validateMovieDetailToDisplay(movie: Movie) {
        val isActiveNetwork = movieDetailIntent.isActiveNetwork()
        withContext(Dispatchers.IO) {
            when (val movieDetail = movieDetailRepository.getMovieDetail(movie, isActiveNetwork)) {
                is MovieResponse.Success -> {
                    this@MovieDetailViewModel.movie = movieDetail.response
                    showMovieDetail()
                }
                is MovieResponse.Error -> {
                    movieDetailIntent.displayMovieError()
                }
            }
        }
    }

    private fun showMovieDetail() {
        movieDetailIntent.loadMovieDetail(movie)
        movieDetailIntent.displayMovieDetailScreen()
    }
}
