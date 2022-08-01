package com.jmonzonm.data.repositoriy

import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import javax.inject.Inject

class PokeApiRepository @Inject constructor(
    //private val localDataSource: PokemonLocalDataSource
    private val remoteDataSource: PokemonRemoteDataSource
) {
    fun getPokemonList() {
        TODO("Not yet implemented")
    }

    fun getTeamPokemonList() {
        TODO("Not yet implemented")
    }
}