package com.vinicius.marvelwiki.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.Utils
import com.vinicius.marvelwiki.commons.BaseFragment
import com.vinicius.marvelwiki.ui.activity.main.GenericContainerAdapter

abstract class ContainerFragment : BaseFragment(),
    ContainerFragmentContract {

    var myAdapter: GenericContainerAdapter? = null

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
            it.layoutManager = GridLayoutManager(requireActivity(), Utils.calculateBestSpanCount(requireActivity().windowManager, 500))
        }
    }
}

interface ContainerFragmentContract {
    fun setAdapter(): GenericContainerAdapter
}
