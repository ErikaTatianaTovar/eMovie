package com.proyecto.emovie.infraestructure.network.dto

import com.proyecto.emovie.infraestructure.network.vos.genres.GenresVo

fun GenresVo.toGenresName(genresIds: List<Int>): String {
    val genresName = ArrayList<String>()
    genresIds.forEach { idGenre ->
        this.genres.find { it.id == idGenre }?.let {
            genresName.add(it.name)
        }
    }
    return genresName.joinToString(" $bullet ")
}

const val bullet = "•"

