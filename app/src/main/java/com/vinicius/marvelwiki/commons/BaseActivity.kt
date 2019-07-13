package com.vinicius.marvelwiki.commons

import androidx.appcompat.app.AppCompatActivity
import com.vinicius.marvelwiki.viewModel.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onStop() {
        super.onStop()
        DisposableManager.dispose()
    }
}