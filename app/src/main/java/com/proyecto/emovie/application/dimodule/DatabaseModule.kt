package com.proyecto.emovie.application.dimodule

import android.content.Context
import com.proyecto.emovie.infraestructure.dblocal.AppDataBase
import com.proyecto.emovie.infraestructure.dblocal.daos.MovieDao
import com.proyecto.emovie.infraestructure.dblocal.daos.MovieDetailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDataBase =
            AppDataBase.getInstance(context)

    @Provides
    fun provideMovieDao(appDataBase: AppDataBase): MovieDao = appDataBase.movieDao()

    @Provides
    fun provideMovieDetailDao(appDataBase: AppDataBase): MovieDetailDao = appDataBase.movieDetailDao()
}