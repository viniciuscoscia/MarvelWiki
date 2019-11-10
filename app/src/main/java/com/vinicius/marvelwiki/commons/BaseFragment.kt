package com.vinicius.marvelwiki.commons

import androidx.fragment.app.Fragment
import com.vinicius.marvelwiki.viewModel.ViewModelFactory
import javax.inject.Inject

open class BaseFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onStop() {
        super.onStop()
        DisposableManager.dispose()
    }
}
