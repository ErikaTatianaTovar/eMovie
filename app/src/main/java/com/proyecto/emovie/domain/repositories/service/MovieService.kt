package com.proyecto.emovie.domain.repositories.service

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.infraestructure.network.response.MovieResponse

interface MovieService {
    suspend fun getMoviesUpcoming(): MovieResponse<List<Movie>>
    suspend fun getMoviesTopRated(): MovieResponse<List<Movie>>
    suspend fun getMoviesRecommendedForYou(): MovieResponse<List<Movie>>
}