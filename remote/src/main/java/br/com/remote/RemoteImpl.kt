package br.com.remote

import MarvelWiki.remote.BuildConfig
import br.com.data.repository.Remote
import br.com.domain.model.CharactersRequest
import br.com.remote.service.IMarvelAPI
import io.reactivex.Observable
import javax.inject.Inject

class RemoteImpl @Inject constructor(private val service: IMarvelAPI): Remote{
    override fun getAllCharacters(): Observable<CharactersRequest> {
        val time = IMarvelAPI.getTimestamp()
        return service.getAllCharacters(time, BuildConfig.API_PUBLIC_KEY, IMarvelAPI.getHash(time, BuildConfig.API_PRIVATE_KEY))
    }
}