package com.jmonzonm.data.repositoriy.datasource

import arrow.core.Either
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(): Either<Failure, List<Pokemon>>
}