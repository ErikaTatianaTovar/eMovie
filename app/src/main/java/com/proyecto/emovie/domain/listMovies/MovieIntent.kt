package com.proyecto.emovie.domain.listMovies

import com.proyecto.emovie.domain.models.MoviePerCategory

interface MovieIntent {
    fun loadListMovies(movies: List<MoviePerCategory>)
    fun displayMoviesScreen()
    fun displayNotFoundDataScreen()
    fun isActiveNetwork(): Boolean
}