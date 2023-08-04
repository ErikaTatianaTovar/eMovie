package com.proyecto.emovie.application.ui.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyecto.emovie.application.ui.fragments.moviehome.EventListMovie
import com.proyecto.emovie.databinding.ItemMovieBinding
import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MoviePerCategory

class MovieViewHolder(
    private val eventListMovie: EventListMovie,
    private val itemMovieBinding: ItemMovieBinding
) : RecyclerView.ViewHolder(itemMovieBinding.root) {

    fun bind(item: Movie) {
        Glide.with(itemMovieBinding.imbMovie)
            .load(item.posterPath)
            .into(itemMovieBinding.imbMovie)

        itemMovieBinding.imbMovie.setOnClickListener {
            eventListMovie.clickToMovie(item)
        }
    }
}