package com.proyecto.emovie.domain.repositories.service

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MovieDetail
import com.proyecto.emovie.infraestructure.network.response.MovieResponse

interface MovieDetailService {
    suspend fun getMovieDetail(movie: Movie): MovieResponse<MovieDetail>
}