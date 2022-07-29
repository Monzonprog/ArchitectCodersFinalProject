package com.jmonzonm.pokeapi.data.network.models

import com.google.gson.annotations.SerializedName

data class PokemonListModels(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: Any? = null,
    @SerializedName("results")
    val results: List<Result?>? = null
)

data class Result(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)