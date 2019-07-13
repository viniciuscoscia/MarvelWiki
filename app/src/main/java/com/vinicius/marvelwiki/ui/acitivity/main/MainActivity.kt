package com.vinicius.marvelwiki.ui.acitivity.main

import android.os.Bundle
import android.util.Log
import br.com.remote.service.IMarvelAPI
import br.com.utils.Constants
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.commons.BaseActivity
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var api: IMarvelAPI
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        val a = api.getAllCharacters(IMarvelAPI.getTimeInMillis(), Constants.PUBLIC_KEY, IMarvelAPI.getHash())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val b =
            a.subscribe { charRequest -> Log.d("TEXTO", (charRequest.data.results[1].name))}

    }

}

