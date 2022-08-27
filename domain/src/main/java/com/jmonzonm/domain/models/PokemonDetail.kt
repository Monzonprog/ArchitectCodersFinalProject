package com.jmonzonm.domain.models

data class PokemonDetail(
    val id: Int,
    val name: String,
    val moves: List<String>,
    val type: List<String>,
    val image: String
)