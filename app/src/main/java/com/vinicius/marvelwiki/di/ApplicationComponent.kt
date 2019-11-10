package com.vinicius.marvelwiki.di

import com.vinicius.marvelwiki.commons.BaseApp
import com.vinicius.marvelwiki.di.module.ApplicationModule
import com.vinicius.marvelwiki.di.module.MyViewModelModule
import com.vinicius.marvelwiki.di.module.PresentationModule
import com.vinicius.marvelwiki.di.module.RemoteModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    MyViewModelModule::class,
    ApplicationModule::class,
    PresentationModule::class,
    RemoteModule::class])
interface ApplicationComponent : AndroidInjector<BaseApp> {

//    override fun inject(application: BaseApp)

    @Component.Builder
    interface Builder {
//        @BindsInstance
//        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}