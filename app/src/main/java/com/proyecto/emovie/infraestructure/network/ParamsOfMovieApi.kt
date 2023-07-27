package com.proyecto.emovie.infraestructure.network

object ParamsOfMovieApi {
    const val baseUrl = "https://api.themoviedb.org/"
    const val accessToken =
        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0OGZhNTkyODhhOWFiNGRiMmQ1MGU1MjlmNjNmYmQyNyIsInN1YiI6IjYwOGI2YTBiNzdjMDFmMDAzZmE2NDczOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pS8GqAq3k2IJwzMKryvXMXFqPsU2lbvME22ayTKUt2o"
    const val apiKey = "48fa59288a9ab4db2d50e529f63fbd27"
    const val upcoming = "release_date.asc"
    const val topRated = "vote_average.asc"
    const val baseUrlImage = "https://image.tmdb.org/t/p/w500"
}