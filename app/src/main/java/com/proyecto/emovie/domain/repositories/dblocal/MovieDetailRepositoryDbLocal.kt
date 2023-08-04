package com.proyecto.emovie.domain.repositories.dblocal

import com.proyecto.emovie.domain.models.MovieDetail
import com.proyecto.emovie.infraestructure.dblocal.entitys.MovieDetailEntity

interface MovieDetailRepositoryDbLocal {
    fun getMovieDetail(idMovieDetail: Int): MovieDetail
    fun insertMovieDetail(entity: MovieDetailEntity)
}