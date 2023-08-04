package com.proyecto.emovie.domain.services.online

import com.proyecto.emovie.domain.repositories.dblocal.MovieRepositoryDbLocal
import com.proyecto.emovie.domain.repositories.repository.MovieRepository.Companion.recommendedForYouId
import com.proyecto.emovie.domain.repositories.repository.MovieRepository.Companion.tendencyId
import com.proyecto.emovie.domain.repositories.repository.MovieRepository.Companion.upcomingReleasesId
import com.proyecto.emovie.domain.repositories.service.MovieService
import com.proyecto.emovie.infraestructure.dblocal.dtos.toMovieEntity
import com.proyecto.emovie.infraestructure.network.ParamsOfMovieApi.topRated
import com.proyecto.emovie.infraestructure.network.ParamsOfMovieApi.upcoming
import com.proyecto.emovie.infraestructure.network.daos.MovieDaoRetroFit
import com.proyecto.emovie.infraestructure.network.dto.toMovies
import com.proyecto.emovie.infraestructure.network.response.MovieResponse
import javax.inject.Inject

class MovieOnlineService @Inject constructor(
    private val movieDaoRetroFit: MovieDaoRetroFit,
    private val movieRepositoryDbLocal: MovieRepositoryDbLocal
) : MovieService {

    override suspend fun getMoviesUpcoming() =
        when (val response =
            MovieResponse.validateResponse(movieDaoRetroFit.getMovies(sortBy = upcoming))) {
            is MovieResponse.Success -> {
                val movies = response.response.toMovies()
                movieRepositoryDbLocal.insertAll(movies.toMovieEntity(upcomingReleasesId))
                MovieResponse.Success(movies)
            }
            is MovieResponse.Error -> {
                MovieResponse.Error()
            }
        }

    override suspend fun getMoviesTopRated() =
        when (val response =
            MovieResponse.validateResponse(movieDaoRetroFit.getMovies(sortBy = topRated))) {
            is MovieResponse.Success -> {
                val movies = response.response.toMovies()
                movieRepositoryDbLocal.insertAll(movies.toMovieEntity(tendencyId))
                MovieResponse.Success(movies)
            }
            is MovieResponse.Error -> {
                MovieResponse.Error()
            }
        }

    override suspend fun getMoviesRecommendedForYou() =
        when (val response =
            MovieResponse.validateResponse(movieDaoRetroFit.getMoviesRecommendedForYou())) {
            is MovieResponse.Success -> {
                val movies = response.response.toMovies()
                movieRepositoryDbLocal.insertAll(movies.toMovieEntity(recommendedForYouId))
                MovieResponse.Success(movies)
            }
            is MovieResponse.Error -> {
                MovieResponse.Error()
            }
        }
}
