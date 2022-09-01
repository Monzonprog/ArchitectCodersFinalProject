package com.jmonzonm.pokeapi.presentation.testhelpers

import com.jmonzonm.pokeapi.data.database.PokemonDao
import com.jmonzonm.pokeapi.data.database.models.PokemonDBModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakePokemonDao(pokemonList: List<PokemonDBModel>) : PokemonDao {

    private val pokemonDBelements = MutableStateFlow(pokemonList)
    private lateinit var pokemonFlow: MutableStateFlow<PokemonDBModel>

    override fun getAllPokemon(): Flow<List<PokemonDBModel>> {
        return pokemonDBelements
    }

    override suspend fun insertPokemons(pokemons: List<PokemonDBModel>) {
        pokemonDBelements.value = pokemons
        if (::pokemonFlow.isInitialized) {
            pokemons.firstOrNull() { it.name == pokemonFlow.value.name }
                ?.let { pokemonFlow.value = it }
        }
    }

    override suspend fun pokemonCount(): Int {
        return pokemonDBelements.value.size
    }


}