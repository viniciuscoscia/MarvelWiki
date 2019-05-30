package com.vinicius.marvelwiki.commons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vinicius.marvelwiki.di.network.DaggerNetworkComponent
import com.vinicius.marvelwiki.di.network.NetworkComponent

abstract class BaseActivity : AppCompatActivity() {
    lateinit var component: NetworkComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
    }

    private fun setup() {
        component = DaggerNetworkComponent.builder().build()
        component.inject(this)
    }
}