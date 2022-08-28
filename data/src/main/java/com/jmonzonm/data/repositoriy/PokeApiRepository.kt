package com.jmonzonm.data.repositoriy

import arrow.core.Either
import com.jmonzonm.data.repositoriy.datasource.PokemonLocalDataSource
import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.PokemonDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeApiRepository @Inject constructor(
    private val localDataSource: PokemonLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) {

    val pokemonList get() = localDataSource.pokemons

    suspend fun getPokemonList(): Failure? {
        if (localDataSource.isEmpty()) {
            remoteDataSource.getPokemonList().fold(
                {
                    return it
                }, {
                    localDataSource.insertInDB(it)
                }

            )
        }
        return null
    }

    suspend fun getPokemonDetail(id: String): Flow<Either<Failure, PokemonDetail>> {
        return remoteDataSource.getPokemonDetail(id = id)
    }
}