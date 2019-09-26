package com.vinicius.marvelwiki.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.vinicius.marvelwiki.Utils
import com.vinicius.marvelwiki.ui.activity.main.CharacterAdapter
import kotlinx.android.synthetic.main.fragment_data_container.*

class DataContainerFragment : Fragment() {
    private var myAdapter = CharacterAdapter(requireContext())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupRecyclerView() = with(mainRecyclerView) {
        adapter = myAdapter
        setHasFixedSize(true)
        layoutManager = GridLayoutManager(
            requireActivity(),
            Utils.calculateBestSpanCount(requireActivity().windowManager, 400)
        )
    }
}