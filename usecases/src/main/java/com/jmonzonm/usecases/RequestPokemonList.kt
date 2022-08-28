package com.jmonzonm.usecases

import com.jmonzonm.data.repositoriy.PokeRepository
import com.jmonzonm.domain.models.Failure
import javax.inject.Inject

class RequestPokemonList @Inject constructor(private val pokemonRepository: PokeRepository) {
    suspend operator fun invoke(): Failure? {
        return pokemonRepository.getPokemonList()
    }
}