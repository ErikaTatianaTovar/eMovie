package com.proyecto.emovie.infraestructure.dblocal.dtos

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.infraestructure.dblocal.entitys.MovieEntity

fun List<Movie>.toMovieEntity(idCategory: Int): List<MovieEntity> {
    return map {
        MovieEntity(
            id = it.id,
            genreIds = it.genreIds.joinToString(","),
            originalLanguage = it.originalLanguage,
            originalTitle = it.originalTitle,
            overview = it.overview,
            posterPath = it.posterPath,
            releaseDate = it.releaseDate,
            title = it.title,
            voteAverage = it.voteAverage,
            idCategory = idCategory
        )
    }
}

fun List<MovieEntity>.toDomainModel(): List<Movie> {
    return map { movieEntity ->
        Movie(
            id = movieEntity.id,
            genreIds = movieEntity.genreIds.split(",").map { it.toInt() },
            originalLanguage = movieEntity.originalLanguage,
            originalTitle = movieEntity.originalTitle,
            overview = movieEntity.overview,
            posterPath = movieEntity.posterPath,
            releaseDate = movieEntity.releaseDate,
            title = movieEntity.title,
            voteAverage = movieEntity.voteAverage
        )
    }
}