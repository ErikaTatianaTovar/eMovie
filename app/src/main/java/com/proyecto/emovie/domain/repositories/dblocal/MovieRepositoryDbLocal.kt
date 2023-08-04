package com.proyecto.emovie.domain.repositories.dblocal

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.infraestructure.dblocal.entitys.MovieEntity

interface MovieRepositoryDbLocal {
    fun getAllMovies(idCategory: Int): List<Movie>
    fun insertAll(entities: List<MovieEntity>)
}