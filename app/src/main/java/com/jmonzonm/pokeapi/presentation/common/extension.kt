package com.jmonzonm.pokeapi.presentation.common

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.jmonzonm.pokeapi.R

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
        .placeholder(R.drawable.pokemon_title)
        .target(this)
        .build()

    imageLoader.enqueue(request)
}
