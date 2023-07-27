package com.proyecto.emovie.infraestructure.network.dto

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.infraestructure.network.vos.movies.MoviesVo

fun MoviesVo.toMovies(): List<Movie> = this.results.map {
    Movie(
        it.genreIds,
        it.id,
        it.originalLanguage,
        it.originalTitle,
        it.overview,
        it.posterPath,
        it.releaseDate,
        it.title,
        it.voteAverage.toString()
    )
}