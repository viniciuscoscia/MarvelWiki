package com.vinicius.marvelwiki.ui.fragment.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.commons.ContainerFragment
import com.vinicius.marvelwiki.ui.activity.main.CharacterAdapter

class CharactersFragment : ContainerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setAdapter(): RecyclerView.Adapter<out RecyclerView.ViewHolder> {
        return CharacterAdapter(requireActivity().applicationContext)
    }

}