package com.proyecto.emovie.application.ui.detailmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailMoviesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is detail Fragment"
    }
    val text: LiveData<String> = _text
}