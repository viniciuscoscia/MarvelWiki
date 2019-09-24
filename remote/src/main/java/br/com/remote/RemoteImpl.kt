package br.com.remote

import br.com.data.repository.Remote
import br.com.domain.model.CharactersRequest
import br.com.remote.service.IMarvelAPI
import br.com.utils.Constants
import io.reactivex.Observable
import javax.inject.Inject

class RemoteImpl @Inject constructor(private val service: IMarvelAPI): Remote{
    override fun getAllCharacters(): Observable<CharactersRequest> {
        val time = IMarvelAPI.getTimeInMillis()
        return service.getAllCharacters(time, Constants.PUBLIC_KEY, IMarvelAPI.getHash(time))
    }
}