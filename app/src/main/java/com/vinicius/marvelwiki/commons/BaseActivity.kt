package com.vinicius.marvelwiki.commons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vinicius.marvelwiki.viewModel.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }

    override fun onStop() {
        super.onStop()
        DisposableManager.dispose()
    }
}