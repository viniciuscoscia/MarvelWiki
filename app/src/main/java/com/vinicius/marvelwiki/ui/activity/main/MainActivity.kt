package com.vinicius.marvelwiki.ui.activity.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.Utils
import com.vinicius.marvelwiki.commons.BaseActivity
import com.vinicius.marvelwiki.commons.DisposableManager
import com.vinicius.marvelwiki.viewModel.MainViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var viewModel: MainViewModel
    private var myAdapter = CharacterAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        initViewModel()
        setupRecyclerView()
        searchCharacters()
    }

    private fun setupRecyclerView() = with(mainRecyclerView) {
        adapter = myAdapter
        setHasFixedSize(true)
        layoutManager = GridLayoutManager(this@MainActivity, Utils.calculateBestSpanCount(windowManager, 400))
    }

    private fun searchCharacters() {
        val disposable = viewModel
            .getAllCharacters()
            .subscribe({ characters ->
                myAdapter.setCharacters(characters)
            }, { error ->
                Log.e(this::javaClass.name, error.message)
            })
        DisposableManager.add(disposable)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

}

