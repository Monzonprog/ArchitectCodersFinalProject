package com.jmonzonm.data.repositoriy

import arrow.core.Either
import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.domain.models.PokemonDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeApiRepository @Inject constructor(
    //private val localDataSource: PokemonLocalDataSource
    private val remoteDataSource: PokemonRemoteDataSource
) {
    suspend fun getPokemonList(): Flow<Either<Failure, List<Pokemon>>> {
        return remoteDataSource.getPokemonList()
    }

    suspend fun getPokemonDetail(id: String): Flow<Either<Failure, PokemonDetail>> {
        return remoteDataSource.getPokemonDetail(id = id)
    }

    fun getTeamPokemonList() {
        TODO("Not yet implemented")
    }
}