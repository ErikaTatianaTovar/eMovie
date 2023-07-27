package com.proyecto.emovie.infraestructure.dblocal.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.proyecto.emovie.infraestructure.dblocal.entitys.MovieDetailEntity

@Dao
interface MovieDetailDao {

    @Query("SELECT * FROM MovieDetail WHERE idMovieDetail = :idMovieDetail")
    fun getMovieDetail(idMovieDetail: Int): MovieDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entity: MovieDetailEntity)
}