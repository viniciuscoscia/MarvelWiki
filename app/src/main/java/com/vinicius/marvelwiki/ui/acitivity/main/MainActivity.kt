package com.vinicius.marvelwiki.ui.acitivity.main

import android.os.Bundle
import br.com.domain.model.Character
import br.com.domain.model.CharactersRequest
import br.com.remote.service.IMarvelAPI
import br.com.utils.Constants
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.commons.BaseActivity
import dagger.android.AndroidInjection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var api: IMarvelAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        api.getAllCharacters(IMarvelAPI.getTimeInMillis(), Constants.PUBLIC_KEY, IMarvelAPI.getHash())
            .subscribe()
    }

}
