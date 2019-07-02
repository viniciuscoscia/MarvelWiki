package com.vinicius.marvelwiki.di.module

import com.vinicius.marvelwiki.ui.acitivity.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PresentationModule {

    @ContributesAndroidInjector
    abstract fun contruibutesMainActivity(): MainActivity

}