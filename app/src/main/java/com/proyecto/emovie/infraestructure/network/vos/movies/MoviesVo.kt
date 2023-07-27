package com.proyecto.emovie.infraestructure.network.vos.movies

import com.google.gson.annotations.SerializedName

data class MoviesVo(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("results") val results: List<MovieVo>
)