package com.jmonzonm.pokeapi.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.R
import com.jmonzonm.pokeapi.databinding.PokemonItemBinding

class PokemonAdapter(private val action: (Pokemon) -> Unit) :
    ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = getItem(position)
        pokemon?.let {
            holder.bind(it, position)
            holder.itemView.setOnClickListener { action(pokemon) }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = PokemonItemBinding.bind(view)
        fun bind(pokemon: Pokemon, position: Int) {
            binding.apply {
                tvPokemonPosition.text = "${position + 1}. "
                tvPokemonName.text = pokemon.name?.uppercase()
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pokemon>() {

            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem == newItem
            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) =
                (oldItem.name == newItem.name && oldItem.position == newItem.position)

        }
    }


}

