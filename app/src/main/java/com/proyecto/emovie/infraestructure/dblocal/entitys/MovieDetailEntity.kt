package com.proyecto.emovie.infraestructure.dblocal.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieDetail")
data class MovieDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = "idMovieDetail")
    val id: Int,
    val genres: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: String,
    val voteAverage: String
)