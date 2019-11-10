package com.vinicius.marvelwiki.di.module

import androidx.lifecycle.ViewModelProvider
import com.vinicius.marvelwiki.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}