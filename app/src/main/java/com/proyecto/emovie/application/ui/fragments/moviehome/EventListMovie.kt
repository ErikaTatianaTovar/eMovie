package com.proyecto.emovie.application.ui.fragments.moviehome

import com.proyecto.emovie.domain.models.Movie

interface EventListMovie {
    fun clickToMovie(movie: Movie)
}