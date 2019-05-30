package com.vinicius.marvelwiki.di.application

import android.app.Application
import com.vinicius.marvelwiki.commons.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return baseApp
    }
}