package com.proyecto.emovie.application.ui.utilities

import android.content.Intent
import android.net.Uri
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("linkDirection")
fun sendUrl(view: TextView, url: String?) {
    if (!url.isNullOrEmpty()) {
        view.setOnClickListener {
            Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(url) }.also {
                ContextCompat.startActivity(view.context, it, null)
            }
        }
    }
}