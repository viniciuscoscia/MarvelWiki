package com.vinicius.marvelwiki.ui.acitivity.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.commons.BaseActivity
import com.vinicius.marvelwiki.viewModel.MainViewModel
import dagger.android.AndroidInjection

class MainActivity : BaseActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        initViewModel()
        searchCharacters()
    }

    private fun searchCharacters() {
        viewModel.fetchCharacters()
        viewModel.getCharacterList().observe(this, androidx.lifecycle.Observer { personagens ->
            personagens.forEach { personagem ->
                Log.d("Personagem", personagem.name)
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

}

