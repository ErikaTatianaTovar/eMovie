package com.proyecto.emovie.domain.movieDetail

import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MovieDetail


fun Movie.toMovieDetail(movieTrailer: String, genres: String) = MovieDetail(
    genres = genres,
    id = this.id,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    overview = this.overview,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title,
    video = movieTrailer,
    voteAverage = this.voteAverage,
)
