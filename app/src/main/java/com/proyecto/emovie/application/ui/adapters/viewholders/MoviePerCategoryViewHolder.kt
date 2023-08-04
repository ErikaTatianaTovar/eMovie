package com.proyecto.emovie.application.ui.adapters.viewholders

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyecto.emovie.R
import com.proyecto.emovie.application.ui.adapters.MovieAdapter
import com.proyecto.emovie.application.ui.fragments.moviehome.EventListMovie
import com.proyecto.emovie.databinding.ItemMoviePerCategoryBinding
import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MoviePerCategory
import com.proyecto.emovie.infraestructure.network.response.MovieResponse

class MoviePerCategoryViewHolder(
    private val itemMoviePerCategoryBinding: ItemMoviePerCategoryBinding
) : RecyclerView.ViewHolder(itemMoviePerCategoryBinding.root) {

    fun bind(item: MoviePerCategory) {
        itemMoviePerCategoryBinding.tvTitleMovieCategory.text = item.nameCategory
        validateDataOfMovies(item.listOfMovies)
    }

    private fun validateDataOfMovies(listOfMovies: MovieResponse<List<Movie>>) {
        when (listOfMovies) {
            is MovieResponse.Success -> {
                showListMovies(listOfMovies.response)
            }

            is MovieResponse.Error -> {
                showNotFoundMovies()
            }
        }
    }

    private fun showListMovies(listOfMovies: List<Movie>) {
        with(itemMoviePerCategoryBinding) {
            tvNotFoundMovies.visibility = View.GONE
            rvMovies.visibility = View.VISIBLE
        }
        setDataToMoviesPerCategory(listOfMovies)
    }

    private fun showNotFoundMovies() {
        with(itemMoviePerCategoryBinding) {
            tvNotFoundMovies.visibility = View.VISIBLE
            rvMovies.visibility = View.GONE
        }
    }

    private fun setDataToMoviesPerCategory(movies: List<Movie>) {
        itemMoviePerCategoryBinding.rvMovies.visibility = View.VISIBLE
        itemMoviePerCategoryBinding.rvMovies.adapter =
            MovieAdapter(object : EventListMovie {
                override fun clickToMovie(movie: Movie) {
                    itemMoviePerCategoryBinding.root.findNavController().navigate(
                        R.id.action_MovieHomeFragment_to_detailMoviesFragment, bundleOf(
                            movieKeyOfArguments to movie
                        )
                    )
                }
            })
        (itemMoviePerCategoryBinding.rvMovies.adapter as MovieAdapter).submitList(movies)
    }

    companion object {
        const val movieKeyOfArguments = "movie"
    }
}