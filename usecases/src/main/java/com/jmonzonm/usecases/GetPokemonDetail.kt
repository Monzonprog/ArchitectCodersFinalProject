package com.jmonzonm.usecases

import com.jmonzonm.data.repositoriy.PokeApiRepository
import javax.inject.Inject

class GetPokemonDetail @Inject constructor(private val repository: PokeApiRepository) {
    suspend operator fun invoke(id: String) = repository.getPokemonDetail(id = id)
}