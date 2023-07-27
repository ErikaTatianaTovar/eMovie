package com.proyecto.emovie.infraestructure.network.dto

import com.proyecto.emovie.infraestructure.network.vos.trailers.MoviesTrailerVo

fun MoviesTrailerVo.toLinkMovieTrailer(positionTrailer: Int = 0): String =
    youtubeLink + this.results[positionTrailer].key

const val youtubeLink = "https://www.youtube.com/watch?v="