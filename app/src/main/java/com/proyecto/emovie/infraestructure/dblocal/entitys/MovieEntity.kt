package com.proyecto.emovie.infraestructure.dblocal.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movie")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "idMovie")
    val id: Int,
    val genreIds: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: String,
    val idCategory: Int
)