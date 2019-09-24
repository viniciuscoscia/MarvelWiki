package com.vinicius.marvelwiki.ui.acitivity.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.domain.model.Character
import com.bumptech.glide.Glide
import com.vinicius.marvelwiki.R

class CharacterAdapter(val context: Context) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var characters: List<Character>? = null

    fun setCharacters(newCharacters: List<Character>) {
        characters = newCharacters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters?.size ?: 0
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters?.get(position)!!)
    }

    inner class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.imageChar)

        fun bind(character: Character) {
            Glide.with(context)
                .load("${character.thumbnail.path}.${character.thumbnail.extension}")
                .centerCrop()
                .into(imageView)
        }


    }
}