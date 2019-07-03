package com.vinicius.marvelwiki.ui.acitivity.main

import android.os.Bundle
import br.com.domain.model.CharactersRequest
import br.com.remote.service.IMarvelAPI
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.commons.BaseActivity
import dagger.android.AndroidInjection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var marvelApi: IMarvelAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        marvelApi.getAllCharacters(IMarvelAPI.getTimeInMillis(), br.com.utils.Constants.PUBLIC_KEY, IMarvelAPI.getHash())
                .enqueue(object: Callback<CharactersRequest>{
                    override fun onFailure(call: Call<CharactersRequest>, t: Throwable) {
                        print(call)
                        print(t.toString())
                    }

                    override fun onResponse(call: Call<CharactersRequest>, response: Response<CharactersRequest>) {
                        print("Deu bom")
                    }
                } )
    }
}
