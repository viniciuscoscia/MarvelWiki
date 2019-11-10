package com.vinicius.marvelwiki.ui.activity.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.commons.BaseActivity
import com.vinicius.marvelwiki.viewModel.MainViewModel

class MainActivity : BaseActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        searchCharacters()
    }

    private fun searchCharacters() {
//        val disposable = viewModel
//            .getAllCharacters()
//            .subscribe({ characters ->
//                myAdapter.setCharacters(characters)
//            }, { error ->
//                Log.e(this::javaClass.name, error.message)
//            })
//        DisposableManager.add(disposable)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

}

