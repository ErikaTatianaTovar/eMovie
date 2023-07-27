package com.proyecto.emovie.infraestructure.network.daos

import com.proyecto.emovie.infraestructure.network.ParamsOfMovieApi.accessToken
import com.proyecto.emovie.infraestructure.network.ParamsOfMovieApi.apiKey
import com.proyecto.emovie.infraestructure.network.vos.genres.GenresVo
import com.proyecto.emovie.infraestructure.network.vos.movies.MoviesVo
import com.proyecto.emovie.infraestructure.network.vos.trailers.MoviesTrailerVo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDaoRetroFit {

    @Headers("authorization: $accessToken")
    @GET("4/list/{idList}")
    suspend fun getMovies(
        @Path("idList") idList: String = "1",
        @Query("page") page: String = "1",
        @Query("api_key") apiK: String = apiKey,
        @Query("sort_by") sortBy: String
    ): Response<MoviesVo>

    @Headers("authorization: $accessToken")
    @GET("4/account/{account}/movie/recommendations")
    suspend fun getMoviesRecommendedForYou(
        @Path("account") idList: String = "jbmc",
        @Query("page") page: String = "1"
    ): Response<MoviesVo>

    @Headers("authorization: $accessToken")
    @GET("3/movie/{idMovie}/videos")
    suspend fun getMoviesTrailer(
        @Path("idMovie") idMovie: Int
    ): Response<MoviesTrailerVo>

    @Headers("authorization: $accessToken")
    @GET("3/genre/movie/list")
    suspend fun getMoviesGenres(): Response<GenresVo>
}