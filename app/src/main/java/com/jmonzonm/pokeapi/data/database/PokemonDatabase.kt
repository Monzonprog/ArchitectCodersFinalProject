package com.jmonzonm.pokeapi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jmonzonm.pokeapi.data.database.models.PokemonDBModel

@Database(entities = [PokemonDBModel::class], version = 1, exportSchema = false)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}