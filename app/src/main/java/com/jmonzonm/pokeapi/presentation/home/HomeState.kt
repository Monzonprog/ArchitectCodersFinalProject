package com.jmonzonm.pokeapi.presentation.home

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.jmonzonm.domain.models.Pokemon

class HomeState(private val navController: NavController) {
    fun onPokemonClicked(pokemon: Pokemon) {
        navController.navigate(
            HomeFragmentDirections.actionFromHomefragmentToDetailfragment(
                pokemonID = pokemon.position!!
            )
        )
    }

    fun finishApp(activity: Activity) {
        activity.finish()
    }
}

fun Fragment.buildHomeState(
    navController: NavController = findNavController()
) = HomeState(navController)