package br.com.domain

import br.com.domain.model.CharactersRequest
import io.reactivex.Observable

interface Repository {
    fun getAllCharacters(): Observable<CharactersRequest>
}
