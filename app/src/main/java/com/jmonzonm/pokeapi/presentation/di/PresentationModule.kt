package com.jmonzonm.pokeapi.presentation.di

import androidx.lifecycle.SavedStateHandle
import com.jmonzonm.pokeapi.di.PokemonId
import com.jmonzonm.pokeapi.presentation.detail.DetailFragmentArgs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class PresentationModule {

    @Provides
    @ViewModelScoped
    @PokemonId
    fun providesPokemonId(savaStateHandle: SavedStateHandle) =
        DetailFragmentArgs.fromSavedStateHandle(savaStateHandle).pokemonID
}