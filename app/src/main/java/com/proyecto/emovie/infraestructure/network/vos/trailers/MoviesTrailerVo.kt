package com.proyecto.emovie.infraestructure.network.vos.trailers

import com.google.gson.annotations.SerializedName

data class MoviesTrailerVo(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("results") val results: List<MovieTrailerVo>
)