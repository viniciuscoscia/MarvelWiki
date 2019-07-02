package com.vinicius.marvelwiki.commons

import android.app.Activity
import android.app.Application
import com.vinicius.marvelwiki.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApp: Application(), HasActivityInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = androidInjector

    override fun onCreate() {
        super.onCreate()

        setupDagger()
    }

    private fun setupDagger() {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }
}