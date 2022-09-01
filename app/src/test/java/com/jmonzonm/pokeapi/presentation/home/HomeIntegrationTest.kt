package com.jmonzonm.pokeapi.presentation.home

import app.cash.turbine.test
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.data.database.models.PokemonDBModel

import com.jmonzonm.pokeapi.presentation.testhelpers.buildFakePokemonRepository
import com.jmonzonm.pokeapi.presentation.testhelpers.getDBPokemonListFake
import com.jmonzonm.pokeapi.presentation.testhelpers.getRemotePokemonListFake
import com.jmonzonm.pokeapi.testrules.CoroutinesTestRule
import com.jmonzonm.usecases.GetPokemonList
import com.jmonzonm.usecases.RequestPokemonList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeIntegrationTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private fun buildFakeViewModel(
        localData: List<PokemonDBModel> = emptyList(),
        remoteData: List<Pokemon> = emptyList()
    ): HomeViewModel {
        val pokemonRepository = buildFakePokemonRepository(localData, remoteData)
        return HomeViewModel(
            getPokemonList = GetPokemonList(pokemonRepository),
            requestPokemonList = RequestPokemonList(pokemonRepository)
        )
    }

    @Test
    fun `if local source is fill return that data`() = runTest {
        val homeViewModel = buildFakeViewModel(localData = getDBPokemonListFake())

        homeViewModel.onCreateUi()
        homeViewModel.state.test {
            assertEquals(HomeViewModel.UiState(), awaitItem())
            val pokemon = awaitItem().pokemons
            assertEquals("bulbasaur", pokemon?.get(0)?.name ?: "")
            assertEquals("ivysaur", pokemon?.get(1)?.name ?: "")
        }
    }

    @Test
    fun `if local source is empty the information is loaded from server`() = runTest {
        val homeViewModel = buildFakeViewModel(
            localData = getDBPokemonListFake(),
            remoteData = getRemotePokemonListFake()
        )

        homeViewModel.onCreateUi()
        homeViewModel.state.test {
            assertEquals(HomeViewModel.UiState(), awaitItem())
            val pokemon = awaitItem().pokemons
            assertEquals("venusaur", pokemon?.get(2)?.name ?: "")
            assertEquals("charmander", pokemon?.get(3)?.name ?: "")
        }
    }
}