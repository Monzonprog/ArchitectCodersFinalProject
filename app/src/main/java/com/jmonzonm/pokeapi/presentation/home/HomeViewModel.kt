package com.jmonzonm.pokeapi.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.data.network.toFailure
import com.jmonzonm.usecases.GetPokemonList
import com.jmonzonm.usecases.RequestPokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPokemonList: GetPokemonList,
    private val requestPokemonList: RequestPokemonList
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getPokemonList()
                .catch { failure -> _state.update { it.copy(error = failure.toFailure()) } }
                .collect { pokemons -> _state.update { UiState(pokemons = pokemons) } }
        }
    }


    fun onCreateUi() {
        viewModelScope.launch {
            requestPokemonList()
        }
    }

    data class UiState(
        val pokemons: List<Pokemon>? = null,
        val error: Failure? = null
    )
}