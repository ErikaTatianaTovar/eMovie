package com.proyecto.emovie.domain.models

import java.io.Serializable

data class MovieDetail(
    val genres: String,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: String,
    val voteAverage: String
) : Serializable