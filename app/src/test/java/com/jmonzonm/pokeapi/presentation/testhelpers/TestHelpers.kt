package com.jmonzonm.pokeapi.presentation.testhelpers

import com.jmonzonm.data.repositoriy.PokeRepository
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.data.database.PokemonRoomDataSource
import com.jmonzonm.pokeapi.data.database.models.PokemonDBModel
import com.jmonzonm.pokeapi.data.network.datasource.PokemonServerDataSource

fun getDBPokemonListFake(): List<PokemonDBModel> {
    return listOf(
        PokemonDBModel(
            id = 1,
            name = "bulbasaur",
            url = "https://pokeapi.co/api/v2/pokemon/1/"
        ),
        PokemonDBModel(
            id = 2,
            name = "ivysaur",
            url = "https://pokeapi.co/api/v2/pokemon/2/"
        ),
        PokemonDBModel(
            id = 3,
            name = "venusaur",
            url = "https://pokeapi.co/api/v2/pokemon/3/"
        ),
        PokemonDBModel(
            id = 4,
            name = "charmander",
            url = "https://pokeapi.co/api/v2/pokemon/4/"
        ),
    )
}

fun getRemotePokemonListFake(): List<Pokemon> {
    return listOf(
        Pokemon(
            name = "venusaur",
            url = "https://pokeapi.co/api/v2/pokemon/3/"
        ),
        Pokemon(
            name = "charmander",
            url = "https://pokeapi.co/api/v2/pokemon/4/"
        ),
    )
}

fun buildFakePokemonRepository(
    localData: List<PokemonDBModel> = emptyList(),
    remoteData: List<Pokemon> = emptyList()
): PokeRepository {
    return PokeRepository(
        buildFakeLocalDataSource(localData),
        buildFakeRemoteDataSource(remoteData)
    )
}

fun buildFakeLocalDataSource(localData: List<PokemonDBModel>): PokemonRoomDataSource {
    return PokemonRoomDataSource(FakePokemonDao(localData))
}

fun buildFakeRemoteDataSource(remoteData: List<Pokemon>): PokemonServerDataSource {
    return PokemonServerDataSource(FakePokemonService(remoteData))
}

