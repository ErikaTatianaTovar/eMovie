package com.proyecto.emovie.domain.services.online

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MovieDetail
import com.proyecto.emovie.domain.movieDetail.toMovieDetail
import com.proyecto.emovie.domain.repositories.dblocal.MovieDetailRepositoryDbLocal
import com.proyecto.emovie.domain.repositories.service.MovieDetailService
import com.proyecto.emovie.infraestructure.dblocal.dtos.toMovieDetailEntity
import com.proyecto.emovie.infraestructure.network.daos.MovieDaoRetroFit
import com.proyecto.emovie.infraestructure.network.dto.toGenresName
import com.proyecto.emovie.infraestructure.network.dto.toLinkMovieTrailer
import com.proyecto.emovie.infraestructure.network.response.MovieResponse
import javax.inject.Inject

class MovieDetailOnlineService @Inject constructor(
    private val movieDaoRetroFit: MovieDaoRetroFit,
    private val movieDetailRepositoryDbLocal: MovieDetailRepositoryDbLocal
) : MovieDetailService {

    override suspend fun getMovieDetail(movie: Movie): MovieResponse<MovieDetail> {
        return try {
            val linkTrailer = getMovieTrailer(movie.id)
            val genres = getMovieGender(movie.genreIds)
            val movieDetail = movie.toMovieDetail(linkTrailer, genres)
            movieDetailRepositoryDbLocal.insertMovieDetail(movieDetail.toMovieDetailEntity())
            MovieResponse.Success(movieDetail)
        } catch (e: Exception) {
            MovieResponse.Error()
        }
    }

    private suspend fun getMovieTrailer(idMovie: Int) =
        when (val response =
            MovieResponse.validateResponse(movieDaoRetroFit.getMoviesTrailer(idMovie))) {
            is MovieResponse.Success -> {
                response.response.toLinkMovieTrailer()
            }
            is MovieResponse.Error -> {
                notFound
            }
        }

    private suspend fun getMovieGender(genresIds: List<Int>) =
        when (val response =
            MovieResponse.validateResponse(movieDaoRetroFit.getMoviesGenres())) {
            is MovieResponse.Success -> {
                response.response.toGenresName(genresIds)
            }
            is MovieResponse.Error -> {
                notFound
            }
        }

    companion object {
        const val notFound = "not found data"
    }
}
