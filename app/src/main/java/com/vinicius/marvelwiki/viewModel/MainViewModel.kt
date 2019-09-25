package com.vinicius.marvelwiki.viewModel

import androidx.lifecycle.ViewModel
import br.com.domain.model.Character
import br.com.remote.service.IMarvelAPI
import com.vinicius.marvelwiki.BuildConfig
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val api: IMarvelAPI) : ViewModel() {

    fun getAllCharacters(): Observable<List<Character>> {
        val time = IMarvelAPI.getTimestamp()
        return api.getAllCharacters(time, BuildConfig.API_PUBLIC_KEY, IMarvelAPI.getHash(time, BuildConfig.API_PRIVATE_KEY))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { request -> request.data.results}
}
}
