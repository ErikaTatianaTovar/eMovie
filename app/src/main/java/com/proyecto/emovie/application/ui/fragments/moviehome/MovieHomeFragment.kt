package com.proyecto.emovie.application.ui.fragments.moviehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.proyecto.emovie.application.ui.adapters.MoviePerCategoryAdapter
import com.proyecto.emovie.application.ui.utilities.VerifyNetwork
import com.proyecto.emovie.databinding.MovieHomeFragmentBinding
import com.proyecto.emovie.domain.listMovies.MovieIntent
import com.proyecto.emovie.domain.listMovies.MovieViewModel
import com.proyecto.emovie.domain.models.MoviePerCategory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieHomeFragment : Fragment(), MovieIntent {

    private var _binding: MovieHomeFragmentBinding? = null
    private val binding get() = _binding!!
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MovieHomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeOnMovieIntent()
        subscribeAdapterListMovie()
        movieViewModel.loadMovies()
    }
    private fun subscribeOnMovieIntent() {
        movieViewModel.onMovieIntent(this)
    }

    private fun subscribeAdapterListMovie() {
        binding.rvMoviesPerCategory.adapter = MoviePerCategoryAdapter()
    }

    override fun loadListMovies(movies: List<MoviePerCategory>) {
        (binding.rvMoviesPerCategory.adapter as MoviePerCategoryAdapter).submitList(movies)
    }

    override fun displayMoviesScreen() {
        binding.rvMoviesPerCategory.visibility = View.VISIBLE
        binding.notFountData.visibility = View.GONE
    }

    override fun displayNotFoundDataScreen() {
        binding.rvMoviesPerCategory.visibility = View.VISIBLE
        binding.notFountData.visibility = View.GONE
    }

    override fun isActiveNetwork() = VerifyNetwork.isActiveNetwork(requireContext())

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}