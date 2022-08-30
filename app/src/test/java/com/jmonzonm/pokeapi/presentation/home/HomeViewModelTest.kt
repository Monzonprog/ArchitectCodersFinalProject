package com.jmonzonm.pokeapi.presentation.home

import app.cash.turbine.test
import com.jmonzonm.pokeapi.presentation.home.HomeViewModel.UiState
import com.jmonzonm.pokeapi.testrules.CoroutinesTestRule
import com.jmonzonm.testshared.samplePokemon
import com.jmonzonm.usecases.GetPokemonList
import com.jmonzonm.usecases.RequestPokemonList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var requestPokemonList: RequestPokemonList

    @Mock
    lateinit var getPokemonList: GetPokemonList

    private lateinit var homeViewModel: HomeViewModel

    private val pokemon = listOf(samplePokemon.copy())

    @Before
    fun init() {
        whenever(getPokemonList()).thenReturn(flowOf(pokemon))
        homeViewModel = HomeViewModel(getPokemonList, requestPokemonList)
    }

    @Test
    fun `When method onCreateUi is executed the list is request`() = runTest {
        homeViewModel.onCreateUi()
        runCurrent()
        verify(requestPokemonList).invoke()
    }

    @Test
    fun `State change when pokemon list is loaded`() = runTest {
        homeViewModel.state.test {
            assertEquals(UiState(), awaitItem())
            assertEquals(UiState(pokemons = pokemon), awaitItem())
            cancel()
        }
    }
}