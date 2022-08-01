package com.jmonzonm.domain.usecases

import javax.inject.Inject

class GetPokemonList @Inject constructor(private val repository: PokeApiRepository) {
    operator fun invoke() = repository.getPokemonList()
}