package com.vinicius.marvelwiki.di.module

import android.app.Application
import android.content.Context
import com.vinicius.marvelwiki.commons.BaseApp
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context

}