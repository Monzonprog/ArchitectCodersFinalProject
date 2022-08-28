package com.jmonzonm.pokeapi.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jmonzonm.pokeapi.data.network.launchAndCollect
import com.jmonzonm.pokeapi.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var homeState: HomeState
    private var pokemonAdapter: PokemonAdapter? = null
    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            homeState.finishApp(requireActivity())
        }
        homeViewModel.onCreateUi()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeState = buildHomeState()
        pokemonAdapter = PokemonAdapter { homeState.onPokemonClicked(it) }

        viewLifecycleOwner.launchAndCollect(homeViewModel.state) { it ->
            if (it.pokemons?.isNotEmpty() == true) {
                binding.apply {
                    recycler.adapter = pokemonAdapter
                }
                pokemonAdapter?.submitList(it.pokemons)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}