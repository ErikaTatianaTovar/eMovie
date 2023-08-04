package com.proyecto.emovie.infraestructure.dblocal.repositories

import com.proyecto.emovie.domain.models.MovieDetail
import com.proyecto.emovie.domain.repositories.dblocal.MovieDetailRepositoryDbLocal
import com.proyecto.emovie.infraestructure.dblocal.daos.MovieDetailDao
import com.proyecto.emovie.infraestructure.dblocal.dtos.toDomainModel
import com.proyecto.emovie.infraestructure.dblocal.entitys.MovieDetailEntity
import javax.inject.Inject

class MovieDetailRepositoryRoom @Inject constructor(
    private val movieDetailDao: MovieDetailDao
) : MovieDetailRepositoryDbLocal {

    override fun getMovieDetail(idMovieDetail: Int): MovieDetail {
        return movieDetailDao.getMovieDetail(idMovieDetail).toDomainModel()
    }

    override fun insertMovieDetail(entity: MovieDetailEntity) {
        return movieDetailDao.insertAll(entity)
    }
}