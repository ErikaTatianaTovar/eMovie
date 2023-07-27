package com.proyecto.emovie.infraestructure.network.response

import retrofit2.Response
import java.net.HttpURLConnection

sealed class MovieResponse<T> {
    data class Success<T>(val response: T) : MovieResponse<T>()
    data class Error<T>(val codeError: Int = 0) : MovieResponse<T>()
    companion object {
        fun <T> validateResponse(response: Response<T>): MovieResponse<T> {
            val isValid = if (response.isSuccessful) {
                when (response.code()) {
                    HttpURLConnection.HTTP_OK -> {
                        true
                    }
                    else -> {
                        false
                    }
                }
            } else {
                false
            }

            return if (isValid) {
                val body = response.body()
                if (body == null) {
                    Error()
                } else {
                    Success(body)
                }
            } else {
                Error()
            }
        }
    }
}
