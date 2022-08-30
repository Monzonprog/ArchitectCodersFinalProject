package com.jmonzonm.usecases

import com.jmonzonm.data.repositoriy.PokeRepository
import javax.inject.Inject

class GetPokemonList @Inject constructor(private val repository: PokeRepository) {
    operator fun invoke() = repository.pokemonList
}