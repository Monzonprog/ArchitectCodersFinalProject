package com.jmonzonm.pokeapi.data.network.services

import com.jmonzonm.pokeapi.data.network.models.PokemonDetailModels
import com.jmonzonm.pokeapi.data.network.models.PokemonListModels
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {

    companion object {
        const val POKEMONLIST = "pokemon/?limit=151"
        const val POKEMONDETAIL = "pokemon/{id}"
    }

    @GET(POKEMONLIST)
    suspend fun getPokemonList(): PokemonListModels

    @GET(POKEMONDETAIL)
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetailModels
}