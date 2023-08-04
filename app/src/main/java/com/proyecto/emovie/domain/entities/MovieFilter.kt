package com.proyecto.emovie.domain.entities


import com.proyecto.emovie.domain.models.Movie

class MovieFilter(private val movies: List<Movie>) {

    fun getDefaultMovies(): List<Movie> {
        return movies.subList(initIndex, maxElementWithFilter)
    }

    fun obtainFilteredMovies(filter: String): List<Movie> {
        val filteredMovies =
            movies.filter {
                it.originalLanguage == filter || it.releaseDate.substring(
                    0,
                    4
                ) == filter
            }
        if (filteredMovies.size >= 6)
            return filteredMovies.subList(initIndex, maxElementWithFilter)

        return filteredMovies
    }

    fun getFilters(): List<String> {
        val filterWithElements = ArrayList<String>()
        filterWithElements.addAll(movies.map { it.releaseDate.substring(0, 4) })
        filterWithElements.addAll(movies.map { it.originalLanguage })
        return filterWithElements.distinct()
    }

    companion object {
        private const val initIndex: Int = 0
        const val maxElementWithFilter: Int = 6
    }
}