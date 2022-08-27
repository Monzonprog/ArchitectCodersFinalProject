package com.jmonzonm.pokeapi.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jmonzonm.pokeapi.R
import com.jmonzonm.pokeapi.data.network.launchAndCollect
import com.jmonzonm.pokeapi.databinding.FragmentDetailBinding
import com.jmonzonm.pokeapi.presentation.common.loadFromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()
    private var movesAdapter: ListAdapter? = null
    private var typeAdapter: ListAdapter? = null
    private var detailState: DetailState? = null
    private var _binding: FragmentDetailBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailState = buildDetailState()

        viewLifecycleOwner.launchAndCollect(detailViewModel.state) {
            if (it.pokemonDetail !== null) {
                binding.apply {
                    tvName.text = "${it.pokemonDetail.id}. ${it.pokemonDetail.name.uppercase()}"
                    ivPokemon.loadFromUrl(it.pokemonDetail.image)
                    typeAdapter = ListAdapter(it.pokemonDetail.type)
                    rvTypes.adapter = typeAdapter
                    tvTitleMoves.tvTitle.text = getString(R.string.moves)
                    movesAdapter = ListAdapter(it.pokemonDetail.moves.subList(0, 5))
                    rvMoves.adapter = movesAdapter
                    tvTitleTypes.tvTitle.text = getString(R.string.type)
                    typeAdapter = ListAdapter(it.pokemonDetail.type)
                    cvGoBack.setOnClickListener { detailState?.goBackClicked() }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}