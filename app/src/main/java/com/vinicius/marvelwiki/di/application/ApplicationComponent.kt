package com.vinicius.marvelwiki.di.application

import com.vinicius.marvelwiki.commons.BaseApp
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: BaseApp)

}