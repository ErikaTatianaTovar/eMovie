package com.proyecto.emovie.domain.movieDetail

import com.proyecto.emovie.domain.models.MovieDetail

interface MovieDetailIntent {
    fun loadMovieDetail(movie: MovieDetail)
    fun displayMovieDetailScreen()
    fun displayMovieError()
    fun isActiveNetwork(): Boolean
}