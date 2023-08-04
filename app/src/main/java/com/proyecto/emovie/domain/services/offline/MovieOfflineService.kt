package com.proyecto.emovie.domain.services.offline

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.repositories.dblocal.MovieRepositoryDbLocal
import com.proyecto.emovie.domain.repositories.repository.MovieRepository.Companion.recommendedForYouId
import com.proyecto.emovie.domain.repositories.repository.MovieRepository.Companion.tendencyId
import com.proyecto.emovie.domain.repositories.repository.MovieRepository.Companion.upcomingReleasesId
import com.proyecto.emovie.domain.repositories.service.MovieService
import com.proyecto.emovie.infraestructure.network.response.MovieResponse
import javax.inject.Inject

class MovieOfflineService @Inject constructor(
    private val movieRepositoryDbLocal: MovieRepositoryDbLocal
) : MovieService {

    override suspend fun getMoviesUpcoming(): MovieResponse<List<Movie>> {
        val movies = movieRepositoryDbLocal.getAllMovies(upcomingReleasesId)
        if (movies.isEmpty()) {
            return MovieResponse.Error()
        }
        return MovieResponse.Success(movies)
    }

    override suspend fun getMoviesTopRated(): MovieResponse<List<Movie>> {
        val movies = movieRepositoryDbLocal.getAllMovies(tendencyId)
        if (movies.isEmpty()) {
            return MovieResponse.Error()
        }
        return MovieResponse.Success(movies)
    }

    override suspend fun getMoviesRecommendedForYou(): MovieResponse<List<Movie>> {
        val movies = movieRepositoryDbLocal.getAllMovies(recommendedForYouId)
        if (movies.isEmpty()) {
            return MovieResponse.Error()
        }
        return MovieResponse.Success(movies)
    }

}
