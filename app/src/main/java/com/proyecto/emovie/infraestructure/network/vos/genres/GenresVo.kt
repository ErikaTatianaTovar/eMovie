package com.proyecto.emovie.infraestructure.network.vos.genres


import com.google.gson.annotations.SerializedName

data class GenresVo(
    @field:SerializedName("genres") val genres: List<GenreVo>
)