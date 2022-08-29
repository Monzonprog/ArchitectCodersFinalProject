package com.jmonzonm.pokeapi.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.jmonzonm.domain.models.Failure
import com.jmonzonm.domain.models.PokemonDetail
import com.jmonzonm.pokeapi.data.network.toFailure
import com.jmonzonm.pokeapi.di.PokemonId
import com.jmonzonm.usecases.GetPokemonDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    @PokemonId private val pokemonId: Int,
    private var getPokemonDetail: GetPokemonDetail
) :
    ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getPokemonDetail(pokemonId.toString())
                .catch { failure -> _state.update { it.copy(error = failure.toFailure()) } }
                .collect { pokemonDetail ->
                    _state.update {
                        when (pokemonDetail) {
                            is Either.Left -> {
                                UiState(error = Failure.UnknownFailure("Error"))
                            }
                            is Either.Right -> {
                                UiState(
                                    pokemonDetail = pokemonDetail.value
                                )
                            }
                        }
                    }
                }
        }
    }
}

data class UiState(
    val pokemonDetail: PokemonDetail? = null,
    val error: Failure? = null
)
