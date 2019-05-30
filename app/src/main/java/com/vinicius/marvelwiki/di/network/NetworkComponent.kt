package com.vinicius.marvelwiki.di.network

import com.vinicius.marvelwiki.api.IMarvelAPI
import com.vinicius.marvelwiki.commons.BaseActivity
import com.vinicius.marvelwiki.ui.acitivity.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(activity: BaseActivity)
//    fun inject(activity: MainActivity)
    fun getApi() : IMarvelAPI
}