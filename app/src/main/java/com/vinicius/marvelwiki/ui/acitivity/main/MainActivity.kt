package com.vinicius.marvelwiki.ui.acitivity.main

import android.os.Bundle
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.api.IMarvelAPI
import com.vinicius.marvelwiki.commons.BaseActivity
import com.vinicius.marvelwiki.di.network.DaggerNetworkComponent
import com.vinicius.marvelwiki.models.CharactersRequest
import com.vinicius.marvelwiki.util.Constants
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

        DaggerNetworkComponent.builder().build().inject(this)

        marvelApi.getAllCharacters(IMarvelAPI.getTimeInMillis(), Constants.PUBLIC_KEY, IMarvelAPI.getHash())
            .enqueue(object: Callback<CharactersRequest>{
                override fun onFailure(call: Call<CharactersRequest>, t: Throwable) {
                    print(call)
                    print(t.toString())
                }

                override fun onResponse(call: Call<CharactersRequest>, response: Response<CharactersRequest>) {
                    print("Deu bom")
                }
            } )

//        marvelApi.getAllCharacters(IMarvelAPI.getUrlParams())
//        component.getApi()
//            .getAllCharacters(IMarvelAPI.getTimeInMillis(), Constants.PUBLIC_KEY, IMarvelAPI.getHash())
//            .enqueue(object: Callback<CharactersRequest>{
//                override fun onFailure(call: Call<CharactersRequest>, t: Throwable) {
//                    print(call)
//                    print(t.toString())
//                }
//
//                override fun onResponse(call: Call<CharactersRequest>, response: Response<CharactersRequest>) {
//                    print("Deu bom")
//                }
//            } )
    }
}
