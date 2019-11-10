package com.vinicius.marvelwiki.commons

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.Utils

abstract class ContainerFragment : BaseFragment(), ContainerFragmentContract {

    var myAdapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(view)
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView: RecyclerView? = view.findViewById(R.id.dataContainerRecyclerView)
        myAdapter = this.setAdapter()
        recyclerView?.let {
            it.adapter = myAdapter
            it.setHasFixedSize(true)
            it.layoutManager = GridLayoutManager(
                requireActivity(),
                Utils.calculateBestSpanCount(requireActivity().windowManager, 400)
            )
        }
    }
}

interface ContainerFragmentContract {
    fun setAdapter(): RecyclerView.Adapter<out RecyclerView.ViewHolder>
}
