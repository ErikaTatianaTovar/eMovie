package com.proyecto.emovie.domain.models

import java.io.Serializable

data class Movie(
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: String
) : Serializable