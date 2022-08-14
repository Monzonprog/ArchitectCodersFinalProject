package com.jmonzonm.pokeapi.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmonzonm.domain.models.Pokemon
import com.jmonzonm.pokeapi.R
import com.jmonzonm.pokeapi.databinding.PokemonItemBinding

class PokemonAdapter(private val pokemons: List<Pokemon>?, private val action: (Int) -> Unit) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons?.get(position)
        pokemon?.let {
            holder.bind(it, position)
            holder.itemView.setOnClickListener { action(position + 1) }
        }
    }

    override fun getItemCount(): Int = pokemons!!.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = PokemonItemBinding.bind(view)
        fun bind(pokemon: Pokemon, position: Int) {
            binding.apply {
                tvPokemonPosition.text = "${position + 1}. "
                tvPokemonName.text = pokemon.name?.uppercase()
            }
        }
    }

}
