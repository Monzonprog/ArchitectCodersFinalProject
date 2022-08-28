package com.jmonzonm.data.repositoriy.datasource

import arrow.core.Either
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.domain.models.PokemonDetail
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(): Either<Failure, List<Pokemon>>
    suspend fun getPokemonDetail(id: String): Flow<Either<Failure, PokemonDetail>>
}