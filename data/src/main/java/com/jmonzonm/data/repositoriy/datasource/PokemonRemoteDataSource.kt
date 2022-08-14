package com.jmonzonm.data.repositoriy.datasource

import arrow.core.Either
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    suspend fun pokemonFromNetwork(): Flow<Either<Failure, List<Pokemon>>>
}