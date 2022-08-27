package com.jmonzonm.pokeapi.presentation.detail

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class DetailState(private val navController: NavController) {
    fun goBackClicked() {
        navController.navigateUp()
    }
}

fun Fragment.buildDetailState(
    navController: NavController = findNavController()
) = DetailState(navController)