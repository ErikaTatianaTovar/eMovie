package com.proyecto.emovie.infraestructure.network.vos.trailers

import com.google.gson.annotations.SerializedName

data class MovieTrailerVo(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("key") val key: String
)