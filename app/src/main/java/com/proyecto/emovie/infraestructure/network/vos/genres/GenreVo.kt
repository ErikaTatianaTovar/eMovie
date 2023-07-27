package com.proyecto.emovie.infraestructure.network.vos.genres

import com.google.gson.annotations.SerializedName

data class GenreVo(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("name") val name: String
)