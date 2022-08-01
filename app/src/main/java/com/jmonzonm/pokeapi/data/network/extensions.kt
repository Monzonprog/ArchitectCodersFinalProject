package com.jmonzonm.pokeapi.data.network

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.jmonzonm.domain.models.Failure
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