package com.jmonzonm.pokeapi.presentation.common

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest

fun ImageView.loadFromUrl(url: String) {

    val imageLoader = ImageLoader.Builder(this.context)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

    val request = ImageRequest.Builder(this.context)
        .crossfade(true)
        .crossfade(500)
        .data(url)
        .target(this)
        .build()

    imageLoader.enqueue(request)
}
