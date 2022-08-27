package com.jmonzonm.pokeapi.data.network.datasource


import arrow.core.Either
import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.domain.models.PokemonDetail
import com.jmonzonm.pokeapi.data.network.models.Move
import com.jmonzonm.pokeapi.data.network.models.PokemonDetailModels
import com.jmonzonm.pokeapi.data.network.models.Result
import com.jmonzonm.pokeapi.data.network.models.Type
import com.jmonzonm.pokeapi.data.network.services.PokeApiService
import com.jmonzonm.pokeapi.data.network.tryCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonServerDataSource @Inject constructor(
    private val remoteService: PokeApiService
) : PokemonRemoteDataSource {


    override suspend fun getPokemonList(): Flow<Either<Failure, List<Pokemon>>> = flow {
        emit(tryCall {
            remoteService
                .getPokemonList()
                .results
                .toDomainModel()
        })
    }

    override suspend fun getPokemonDetail(id: String): Flow<Either<Failure, PokemonDetail>> = flow {
        emit(tryCall {
            remoteService
                .getPokemonDetail(id)
                .toDomainModel()

        })
    }
}

private fun PokemonDetailModels.toDomainModel(): PokemonDetail =
    PokemonDetail(
        id = this.id ?: 0,
        name = this.name ?: "",
        moves = this.moves?.toDomainMoveListModel() ?: listOf(),
        type = this.types?.toDomainTypeListModel() ?: listOf(),
        image = createUrlImage(this.id.toString())

    )

private fun createUrlImage(id: String): String {

    val idForImage = when (id.length) {
        1 -> "00${id}"
        2 -> "0${id}"
        else -> id
    }
    return "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${idForImage}.png"
}

private fun List<Move>.toDomainMoveListModel(): List<String> = map {
    it.move?.name ?: ""
}

private fun List<Type>.toDomainTypeListModel(): List<String> = map {
    it.type?.name ?: ""
}

private fun List<Result>.toDomainModel(): List<Pokemon> = map { it.toDomainModel(this.indexOf(it)) }

private fun Result.toDomainModel(position: Int): Pokemon =
    Pokemon(
        position = position + 1,
        name = this.name,
        url = this.url
    )
