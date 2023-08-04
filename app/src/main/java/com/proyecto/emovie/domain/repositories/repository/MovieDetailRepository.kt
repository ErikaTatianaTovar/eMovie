package com.proyecto.emovie.domain.repositories.repository

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MovieDetail
import com.proyecto.emovie.domain.repositories.service.MovieDetailService
import com.proyecto.emovie.domain.services.offline.MovieDetailOfflineService
import com.proyecto.emovie.domain.services.online.MovieDetailOnlineService
import com.proyecto.emovie.infraestructure.network.response.MovieResponse
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(
    private val movieDetailOnlineService: MovieDetailOnlineService,
    private val movieDetailOfflineService: MovieDetailOfflineService
) {

    private lateinit var movieDetailService: MovieDetailService

    suspend fun getMovieDetail(movie: Movie, isActiveNetWork: Boolean): MovieResponse<MovieDetail> {
        validateStateOfNetWork(isActiveNetWork)
        return movieDetailService.getMovieDetail(movie)
    }

    private fun validateStateOfNetWork(isActiveNetWork: Boolean) {
        movieDetailService = if (isActiveNetWork)
            movieDetailOnlineService
        else
            movieDetailOfflineService
    }
}