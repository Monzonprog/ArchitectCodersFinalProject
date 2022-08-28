package com.jmonzonm.pokeapi.data.database

import com.jmonzonm.data.repositoriy.datasource.PokemonLocalDataSource
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.data.database.models.PokemonDBModel
import com.jmonzonm.pokeapi.data.network.tryCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRoomDataSource @Inject constructor(private val pokemonDao: PokemonDao) :
    PokemonLocalDataSource {
    override val pokemons: Flow<List<Pokemon>>
        get() = pokemonDao.getAllPokemon().map { it.toDomainModel() }

    override suspend fun isEmpty(): Boolean {
        return pokemonDao.pokemonCount() == 0
    }

    override suspend fun insertInDB(pokemons: List<Pokemon>): Failure? = tryCall {
        pokemonDao.insertPokemons(pokemons.toDBModel())
    }.fold(
        ifLeft = { it },
        ifRight = { null }
    )
}

private fun List<PokemonDBModel>.toDomainModel(): List<Pokemon> = map { it.toDomainModel() }

private fun PokemonDBModel.toDomainModel(): Pokemon =
    Pokemon(
        position = this.id,
        name = this.name,
        url = this.url
    )

private fun List<Pokemon>.toDBModel(): List<PokemonDBModel> = map { it.toDomainModel() }

private fun Pokemon.toDomainModel(): PokemonDBModel =
    PokemonDBModel(
        id = this.position ?: 0,
        name = this.name ?: "",
        url = this.url ?: ""
    )