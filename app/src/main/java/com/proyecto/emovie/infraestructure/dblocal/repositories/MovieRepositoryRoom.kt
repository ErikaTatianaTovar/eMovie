package com.proyecto.emovie.infraestructure.dblocal.repositories
/*
import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.repositories.dblocal.MovieRepositoryDbLocal
import com.proyecto.emovie.infraestructure.dblocal.daos.MovieDao
import com.proyecto.emovie.infraestructure.dblocal.dtos.toDomainModel
import com.proyecto.emovie.infraestructure.dblocal.entitys.MovieEntity
import javax.inject.Inject

class MovieRepositoryRoom @Inject constructor(
    private val movieDao: MovieDao
) : MovieRepositoryDbLocal {

    override fun getAllMovies(idCategory: Int): List<Movie> {
        return movieDao.getAllMovies(idCategory).toDomainModel()
    }

    override fun insertAll(entities: List<MovieEntity>) {
        return movieDao.insertAll(entities)
    }
}

 */