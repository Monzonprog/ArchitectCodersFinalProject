package com.jmonzonm.pokeapi.presentation.home

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class HomeState(private val navController: NavController) {
    fun onPokemonClicked(pokemonID: Int) {
        navController.navigate(
            HomeFragmentDirections.actionFromHomefragmentToDetailfragment(
                pokemonID = pokemonID
            )
        )
    }
}

fun Fragment.buildHomeState(
    navController: NavController = findNavController()
) = HomeState(navController)