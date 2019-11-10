package com.vinicius.marvelwiki.commons

import com.vinicius.marvelwiki.viewModel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onStop() {
        super.onStop()
        DisposableManager.dispose()
    }
}
