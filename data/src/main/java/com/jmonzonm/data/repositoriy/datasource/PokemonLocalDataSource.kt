package com.jmonzonm.data.repositoriy.datasource

import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonLocalDataSource {
    val pokemons: Flow<List<Pokemon>>
    suspend fun isEmpty(): Boolean
    suspend fun insertInDB(pokemons: List<Pokemon>): Failure?
}