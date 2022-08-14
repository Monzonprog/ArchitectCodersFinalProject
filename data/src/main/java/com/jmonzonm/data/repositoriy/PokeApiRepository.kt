package com.jmonzonm.data.repositoriy

import arrow.core.Either
import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeApiRepository @Inject constructor(
    //private val localDataSource: PokemonLocalDataSource
    private val remoteDataSource: PokemonRemoteDataSource
) {
    suspend fun getPokemonList(): Flow<Either<Failure, List<Pokemon>>> {
        return remoteDataSource.pokemonFromNetwork()
    }

    fun getTeamPokemonList() {
        TODO("Not yet implemented")
    }
}