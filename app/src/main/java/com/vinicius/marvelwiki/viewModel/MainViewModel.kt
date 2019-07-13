package com.vinicius.marvelwiki.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.domain.model.Character
import br.com.remote.service.IMarvelAPI
import br.com.utils.Constants
import com.vinicius.marvelwiki.commons.DisposableManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val api: IMarvelAPI) : ViewModel() {

    private val characterList: MutableLiveData<List<Character>> = MutableLiveData()

    fun getCharacterList(): LiveData<List<Character>> {
        return characterList
    }

    fun fetchCharacters() {
        val call = api.getAllCharacters(IMarvelAPI.getTimeInMillis(), Constants.PUBLIC_KEY, IMarvelAPI.getHash())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { characterList.value = it.data.results }
        DisposableManager.add(call)
    }
}
