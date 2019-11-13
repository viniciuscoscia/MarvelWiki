package com.vinicius.marvelwiki.ui.activity.main

import android.os.Bundle
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.commons.BaseActivity
import com.vinicius.marvelwiki.viewModel.MainViewModel

class MainActivity : BaseActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}

