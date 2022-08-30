package com.jmonzonm.pokeapi.presentation.detail

import com.jmonzonm.pokeapi.testrules.CoroutinesTestRule
import com.jmonzonm.usecases.GetPokemonDetail
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var getPokemonDetail: GetPokemonDetail

    private lateinit var detailViewModel: DetailViewModel

    @Before
    fun init() {
        detailViewModel = DetailViewModel(1, getPokemonDetail)
    }

    @Test
    fun `When viewmodel init call to useCase`() = runTest {
        runCurrent()
        verify(getPokemonDetail).invoke(1)
    }
}