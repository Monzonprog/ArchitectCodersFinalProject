package com.jmonzonm.data.repositoriy

import arrow.core.Either
import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import javax.inject.Inject

class PokeApiRepository @Inject constructor(
    //private val localDataSource: PokemonLocalDataSource
    private val remoteDataSource: PokemonRemoteDataSource
) {
    suspend fun getPokemonList(): Either<Failure, List<Pokemon>> {
        return remoteDataSource.getPokemonList()
    }

    fun getTeamPokemonList() {
        TODO("Not yet implemented")
    }
}