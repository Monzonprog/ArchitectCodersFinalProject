package com.jmonzonm.pokeapi.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonDBModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val url: String
)