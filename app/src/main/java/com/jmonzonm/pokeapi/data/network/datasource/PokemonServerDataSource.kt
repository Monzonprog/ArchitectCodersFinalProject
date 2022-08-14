package com.jmonzonm.pokeapi.data.network.datasource


import arrow.core.Either
import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.data.network.models.Result
import com.jmonzonm.pokeapi.data.network.services.PokeApiService
import com.jmonzonm.pokeapi.data.network.tryCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonServerDataSource @Inject constructor(
    private val remoteService: PokeApiService
) : PokemonRemoteDataSource {


    override suspend fun pokemonFromNetwork(): Flow<Either<Failure, List<Pokemon>>> = flow {
        val pokemon = getPokemonList()
        emit(pokemon)
    }

    private suspend fun getPokemonList(): Either<Failure, List<Pokemon>> = tryCall {
        remoteService
            .getPokemonList()
            .results
            .toDomainModel()
    }

}

private fun List<Result>.toDomainModel(): List<Pokemon> = map { it.toDomainModel() }

private fun Result.toDomainModel(): Pokemon =
    Pokemon(
        name = this.name,
        url = this.url
    )
