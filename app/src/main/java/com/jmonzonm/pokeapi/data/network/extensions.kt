package com.jmonzonm.pokeapi.data.network

import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest.Builder
import com.jmonzonm.domain.models.Failure
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


suspend fun <T> tryCall(action: suspend () -> T): Either<Failure, T> = try {
    action().right()
} catch (e: Exception) {
    e.toFailure().left()
}

fun Throwable.toFailure(): Failure = when (this) {
    is IOException -> Failure.ConnectivityFailure
    is HttpException -> Failure.ServerFailure(code())
    else -> Failure.UnknownFailure(message ?: "")
}

fun <T> LifecycleOwner.launchAndCollect(
    flow: Flow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    body: (T) -> Unit
) {
    lifecycleScope.launch {
        this@launchAndCollect.repeatOnLifecycle(state) {
            flow.collect(body)
        }
    }
}


fun ImageView.loadUrl(url: String) {

    val imageLoader = ImageLoader.Builder(this.context)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

    val request = Builder(this.context)
        .crossfade(true)
        .crossfade(500)
        .data(url)
        .target(this)
        .build()

    imageLoader.enqueue(request)
}
