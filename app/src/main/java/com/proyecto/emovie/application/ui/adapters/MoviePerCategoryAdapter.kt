package com.proyecto.emovie.application.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.emovie.application.ui.adapters.viewholders.MoviePerCategoryViewHolder
import com.proyecto.emovie.application.ui.adapters.viewholders.MoviePerCategoryWithFilterViewHolder
import com.proyecto.emovie.databinding.ItemMoviePerCategoryBinding
import com.proyecto.emovie.databinding.ItemMoviePerCategoryFilterBinding
import com.proyecto.emovie.domain.models.MoviePerCategory

class MoviePerCategoryAdapter :
    ListAdapter<MoviePerCategory, RecyclerView.ViewHolder>(MoviePerCategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == MoviePerCategoryWithFilter)
            return MoviePerCategoryWithFilterViewHolder(
                ItemMoviePerCategoryFilterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        return MoviePerCategoryViewHolder(
            ItemMoviePerCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MoviePerCategoryViewHolder -> holder.bind(getItem(position))
            is MoviePerCategoryWithFilterViewHolder -> holder.bind(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).withFilter) {
            true -> MoviePerCategoryWithFilter
            false -> MoviePerCategory
        }
    }

    companion object {
        const val MoviePerCategory = 0
        const val MoviePerCategoryWithFilter = 1
    }
}

private class MoviePerCategoryDiffCallback : DiffUtil.ItemCallback<MoviePerCategory>() {
    override fun areItemsTheSame(
        oldItem: MoviePerCategory,
        newItem: MoviePerCategory
    ): Boolean =
        oldItem.nameCategory == newItem.nameCategory

    override fun areContentsTheSame(
        oldItem: MoviePerCategory,
        newItem: MoviePerCategory
    ): Boolean =
        oldItem == newItem
}