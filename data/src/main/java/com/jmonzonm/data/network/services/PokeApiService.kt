package com.jmonzonm.data.network.services

import com.jmonzonm.data.network.models.PokemonListModels
import retrofit2.Call
import retrofit2.http.GET

interface PokeApiService {

    companion object {
        const val POKEMONLIST = "/pokemon/?limit=151"
    }

    @GET(POKEMONLIST)
    fun getPokemonList(): Call<PokemonListModels>
}