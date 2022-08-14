package com.jmonzonm.pokeapi.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.usecases.GetPokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var getPokemonList: GetPokemonList) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun init() {
        viewModelScope.launch {
            val pokemon = getPokemonList()
            Log.d("PokemonList ->", pokemon.toString())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val pokemons: List<Pokemon>? = null,
        val error: Error? = null
    )
}