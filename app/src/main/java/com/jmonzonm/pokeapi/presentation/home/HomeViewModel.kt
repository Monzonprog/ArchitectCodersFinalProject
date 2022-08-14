package com.jmonzonm.pokeapi.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.data.network.toFailure
import com.jmonzonm.usecases.GetPokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var getPokemonList: GetPokemonList) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun init() {
        viewModelScope.launch {
            getPokemonList()
                .catch { failure -> _state.update { it.copy(error = failure.toFailure()) } }
                .collect { pokemons -> _state.update { UiState(pokemons = (pokemons as Either.Right).value) } }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val pokemons: List<Pokemon>? = null,
        val error: Failure? = null
    )
}