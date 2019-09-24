package com.vinicius.marvelwiki.viewModel

import androidx.lifecycle.ViewModel
import br.com.domain.model.Character
import br.com.remote.service.IMarvelAPI
import br.com.utils.Constants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val api: IMarvelAPI) : ViewModel() {

    fun getAllCharacters(): Observable<List<Character>> {
        val time = IMarvelAPI.getTimeInMillis()
        return api.getAllCharacters(time, Constants.PUBLIC_KEY, IMarvelAPI.getHash(time))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { request -> request.data.results}
}
}
