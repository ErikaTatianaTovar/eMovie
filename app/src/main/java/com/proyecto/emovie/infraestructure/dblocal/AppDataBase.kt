package com.proyecto.emovie.infraestructure.dblocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proyecto.emovie.infraestructure.dblocal.ParamsOfMovieDbLocal.databaseName
import com.proyecto.emovie.infraestructure.dblocal.daos.MovieDao
import com.proyecto.emovie.infraestructure.dblocal.daos.MovieDetailDao
import com.proyecto.emovie.infraestructure.dblocal.entitys.MovieDetailEntity
import com.proyecto.emovie.infraestructure.dblocal.entitys.MovieEntity

@Database(
    entities = [
        MovieEntity::class,
        MovieDetailEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieDetailDao(): MovieDetailDao

    companion object {

        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}