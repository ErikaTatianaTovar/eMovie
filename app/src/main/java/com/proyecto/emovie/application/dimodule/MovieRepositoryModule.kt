package com.proyecto.emovie.application.dimodule
import com.proyecto.emovie.domain.repositories.service.MovieDetailService
import com.proyecto.emovie.domain.services.offline.MovieDetailOfflineService
import com.proyecto.emovie.domain.services.offline.MovieOfflineService
import com.proyecto.emovie.domain.services.online.MovieDetailOnlineService
import com.proyecto.emovie.domain.services.online.MovieOnlineService
import com.proyecto.emovie.domain.repositories.service.MovieService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class MovieRepositoryModule {

    @Binds
    abstract fun provideMovieOnlineService(movieOnlineService: MovieOnlineService): MovieService

    @Binds
    abstract fun provideMovieOfflineService(movieOfflineService: MovieOfflineService): MovieService

    @Binds
    abstract fun provideMovieDetailOnlineService(movieOnlineService: MovieDetailOnlineService): MovieDetailService

    @Binds
    abstract fun provideMovieDetailOfflineService(movieDetailOfflineService: MovieDetailOfflineService): MovieDetailService

}