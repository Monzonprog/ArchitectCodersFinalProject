package com.jmonzonm.pokeapi.data.network.services

import com.jmonzonm.pokeapi.data.network.models.PokemonListModels
import retrofit2.http.GET

interface PokeApiService {

    companion object {
        const val POKEMONLIST = "pokemon/?limit=151"
    }

    @GET(POKEMONLIST)
    suspend fun getPokemonList(): PokemonListModels
}