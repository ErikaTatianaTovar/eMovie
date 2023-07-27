package com.proyecto.emovie.infraestructure.network.vos.movies

import com.google.gson.annotations.SerializedName

data class MovieVo(
        @field:SerializedName("genre_ids") val genreIds: List<Int>,
        @field:SerializedName("id") val id: Int,
        @field:SerializedName("original_language") val originalLanguage: String,
        @field:SerializedName("original_title") val originalTitle: String,
        @field:SerializedName("overview") val overview: String,
        @field:SerializedName("poster_path") val posterPath: String,
        @field:SerializedName("release_date") val releaseDate: String,
        @field:SerializedName("title") val title: String,
        @field:SerializedName("vote_average") val voteAverage: Double)