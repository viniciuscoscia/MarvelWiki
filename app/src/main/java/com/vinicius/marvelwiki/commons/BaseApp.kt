package com.vinicius.marvelwiki.commons

import android.app.Application
import com.vinicius.marvelwiki.di.application.ApplicationComponent
import com.vinicius.marvelwiki.di.application.DaggerApplicationComponent

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        setupDagger()
    }

    private fun setupDagger() {
        component = DaggerApplicationComponent
            .builder()
            .build()
        component.inject(this)
    }
}