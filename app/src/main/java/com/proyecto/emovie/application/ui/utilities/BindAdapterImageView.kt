package com.proyecto.emovie.application.ui.utilities

import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.proyecto.emovie.infraestructure.network.ParamsOfMovieApi.baseUrlImage

@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageButton, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(baseUrlImage + url)
            .override(200, 300)
            .transform(RoundedCorners(20))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(view)
    }
}

@BindingAdapter("imageUrlBackground")
fun loadImageBackgroud(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(baseUrlImage + url)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(view)
    }
}