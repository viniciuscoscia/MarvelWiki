package com.vinicius.marvelwiki.di

import android.app.Application
import com.vinicius.marvelwiki.commons.BaseApp
import com.vinicius.marvelwiki.di.module.ApplicationModule
import com.vinicius.marvelwiki.di.module.RemoteModule
import com.vinicius.marvelwiki.di.module.PresentationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    ApplicationModule::class,
    PresentationModule::class,
    RemoteModule::class])
interface ApplicationComponent {

    fun inject(application: BaseApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}