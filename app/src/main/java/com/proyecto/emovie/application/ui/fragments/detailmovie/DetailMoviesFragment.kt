package com.proyecto.emovie.application.ui.fragments.detailmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.proyecto.emovie.R
import com.proyecto.emovie.application.ui.adapters.viewholders.MoviePerCategoryViewHolder.Companion.movieKeyOfArguments
import com.proyecto.emovie.application.ui.utilities.VerifyNetwork
import com.proyecto.emovie.databinding.DetailMoviesFragmentBinding
import com.proyecto.emovie.domain.models.Movie
import com.proyecto.emovie.domain.models.MovieDetail
import com.proyecto.emovie.domain.movieDetail.MovieDetailIntent
import com.proyecto.emovie.domain.movieDetail.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMoviesFragment : Fragment(), MovieDetailIntent {

    private var _binding: DetailMoviesFragmentBinding? = null
    private val binding get() = _binding!!
    private val movieDetailViewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DetailMoviesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeOnMovieIntent()
        setActionToToolbar()
        setDataToMovieDetail()
    }

    private fun subscribeOnMovieIntent() {
        movieDetailViewModel.onMovieDetailIntent(this)
    }

    private fun setActionToToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_detailMoviesFragment_pop)
        }
    }

    private fun setDataToMovieDetail() {
        val movie = (arguments?.get(movieKeyOfArguments) as Movie)
        movieDetailViewModel.loadMovieDetail(movie)
    }

    override fun loadMovieDetail(movie: MovieDetail) {
        binding.movieDetail = movie
    }

    override fun displayMovieDetailScreen() {
        binding.ctlMovieDetail.visibility = View.VISIBLE
        binding.notFountData.visibility = View.GONE
    }

    override fun displayMovieError() {
        binding.ctlMovieDetail.visibility = View.GONE
        binding.notFountData.visibility = View.VISIBLE
    }

    override fun isActiveNetwork() = VerifyNetwork.isActiveNetwork(requireContext())

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}