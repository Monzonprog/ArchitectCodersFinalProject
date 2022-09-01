package com.jmonzonm.pokeapi.presentation.testhelpers

import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.data.network.models.PokemonDetailModels
import com.jmonzonm.pokeapi.data.network.models.PokemonListModels
import com.jmonzonm.pokeapi.data.network.models.Result
import com.jmonzonm.pokeapi.data.network.services.PokeApiService

class FakePokemonService(private val remoteData: List<Pokemon>) : PokeApiService {
    override suspend fun getPokemonList(): PokemonListModels {
        return PokemonListModels(
            count = 1,
            next = "",
            previous = "",
            results = listOf(
                Result(
                    name = remoteData[0].name ?: "",
                    url = remoteData[0].url ?: ""
                ),
                Result(
                    name = remoteData[1].name ?: "",
                    url = remoteData[1].url ?: ""
                )
            )
        )
    }

    override suspend fun getPokemonDetail(id: Int): PokemonDetailModels {
        TODO("Not yet implemented")
    }
}