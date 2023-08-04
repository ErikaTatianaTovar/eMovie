package com.proyecto.emovie.domain.services.offline

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MovieDetail
import com.proyecto.emovie.domain.repositories.dblocal.MovieDetailRepositoryDbLocal
import com.proyecto.emovie.domain.repositories.service.MovieDetailService
import com.proyecto.emovie.infraestructure.network.response.MovieResponse
import javax.inject.Inject

class MovieDetailOfflineService @Inject constructor(
    private val movieDetailRepositoryDbLocal: MovieDetailRepositoryDbLocal
) : MovieDetailService {

    override suspend fun getMovieDetail(movie: Movie): MovieResponse<MovieDetail> {
        return try {
            val movieDetail = movieDetailRepositoryDbLocal.getMovieDetail(movie.id)
            MovieResponse.Success(movieDetail)
        } catch (e: Exception) {
            MovieResponse.Error()
        }
    }
}