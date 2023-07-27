package com.proyecto.emovie.application.ui.detailmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.proyecto.emovie.R
import com.proyecto.emovie.databinding.FragmentDetailMoviesBinding

class DetailMoviesFragment : Fragment() {

    private var _binding: FragmentDetailMoviesBinding? = null
   // detailMovieViewModel : DetailMovieViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DetailMoviesViewModel::class.java)

        _binding = FragmentDetailMoviesBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val textView: TextView = binding.notFountData
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionToToolbar()
       // subscribeOnMovieIntent()
        //setDataToMovieDetail()
    }
private fun setActionToToolbar() {
     binding.toolbar.setNavigationOnClickListener(){
         findNavController().navigate(R.id.action_detailMoviesFragment_pop)
    }
}
    /*private fun subscribeOnMovieIntent() {
        detailMovieViewModel.onMovieDetailIntent(this)
    }
    private fun setDataToMovieDetail() {
        val movie = (arguments?.get(movieKeyOfArguments) as Movie)
        movieDetailViewModel.loadMovieDetail(movie)
    }
    companion object {
        const val movieKeyOfArguments = "movie"
    }

     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}