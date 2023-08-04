package com.proyecto.emovie.domain.models

import com.proyecto.emovie.infraestructure.network.response.MovieResponse

data class MoviePerCategory(
    val nameCategory: String,
    val listOfMovies: MovieResponse<List<Movie>>,
    val withFilter: Boolean
)