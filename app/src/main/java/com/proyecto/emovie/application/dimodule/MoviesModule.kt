package com.proyecto.emovie.application.dimodule
import com.proyecto.emovie.domain.repositories.dblocal.MovieDetailRepositoryDbLocal
import com.proyecto.emovie.domain.repositories.dblocal.MovieRepositoryDbLocal
import com.proyecto.emovie.infraestructure.dblocal.repositories.MovieDetailRepositoryRoom
import com.proyecto.emovie.infraestructure.dblocal.repositories.MovieRepositoryRoom
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class MoviesModule {
    @Binds
    abstract fun provideMovieRepository(movieRepositoryRoom: MovieRepositoryRoom): MovieRepositoryDbLocal

    @Binds
    abstract fun provideMovieDetailRepository(movieDetailRepositoryRoom: MovieDetailRepositoryRoom): MovieDetailRepositoryDbLocal
}
