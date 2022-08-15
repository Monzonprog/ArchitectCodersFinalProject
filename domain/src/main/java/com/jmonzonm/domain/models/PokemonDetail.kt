package com.jmonzonm.domain.models

data class PokemonDetail(
    val order: Int,
    val name: String,
    val measures: Measures,
    val moves: List<String>,
    val type: List<String>,
    val stats: List<Stats>,
    val image: String
)

data class Measures(
    val weight: Int,
    val height: Int
)

data class Stats(
    val name: String,
    val stat: Int
)