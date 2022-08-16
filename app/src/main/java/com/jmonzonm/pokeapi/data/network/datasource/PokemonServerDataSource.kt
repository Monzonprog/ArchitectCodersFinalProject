package com.jmonzonm.pokeapi.data.network.datasource


import arrow.core.Either
import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import com.jmonzonm.domain.models.*
import com.jmonzonm.pokeapi.data.network.models.Move
import com.jmonzonm.pokeapi.data.network.models.PokemonDetailModels
import com.jmonzonm.pokeapi.data.network.models.Result
import com.jmonzonm.pokeapi.data.network.models.Type
import com.jmonzonm.pokeapi.data.network.services.PokeApiService
import com.jmonzonm.pokeapi.data.network.tryCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.jmonzonm.pokeapi.data.network.models.Stat as ApiStats

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
        measures = Measures(
            weight = this.weight ?: 0,
            height = this.height ?: 0
        ),
        moves = this.moves?.toDomainMoveListModel() ?: listOf(),
        type = this.types?.toDomainTypeListModel() ?: listOf(),
        stats = this.stats?.toDomainStatsListModel() ?: listOf(),
        image = "https://unpkg.com/pokeapi-sprites@2.0.2/sprites/pokemon/other/dream-world/${this.id}.svg"
    )

private fun List<Move>.toDomainMoveListModel(): List<String> = map {
    it.move?.name ?: ""
}

private fun List<Type>.toDomainTypeListModel(): List<String> = map {
    it.type?.name ?: ""
}

private fun List<ApiStats>.toDomainStatsListModel(): List<Stats> = map {
    Stats(
        name = it.stat?.name ?: "",
        stat = it.baseStat ?: 0
    )
}

private fun List<Result>.toDomainModel(): List<Pokemon> = map { it.toDomainModel(this.indexOf(it)) }

private fun Result.toDomainModel(position: Int): Pokemon =
    Pokemon(
        position = position + 1,
        name = this.name,
        url = this.url
    )
