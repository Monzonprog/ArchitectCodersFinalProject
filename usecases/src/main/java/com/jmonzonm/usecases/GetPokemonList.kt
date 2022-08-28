package com.jmonzonm.usecases

import com.jmonzonm.data.repositoriy.PokeApiRepository
import javax.inject.Inject

class GetPokemonList @Inject constructor(private val repository: PokeApiRepository) {
    suspend operator fun invoke() = repository.pokemonList
}