package com.jmonzonm.usecases

import com.jmonzonm.data.repositoriy.PokeRepository
import javax.inject.Inject

class GetPokemonDetail @Inject constructor(private val repository: PokeRepository) {
    suspend operator fun invoke(id: String) = repository.getPokemonDetail(id = id)
}