package com.jmonzonm.pokeapi.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jmonzonm.pokeapi.data.database.models.PokemonDBModel
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM PokemonDBModel")
    fun getAllPokemon(): Flow<List<PokemonDBModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemons(pokemons: List<PokemonDBModel>)

    @Query("SELECT COUNT(id) FROM PokemonDBModel")
    suspend fun pokemonCount(): Int

}