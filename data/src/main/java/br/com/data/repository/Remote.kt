package br.com.data.repository

import br.com.domain.model.CharactersRequest
import io.reactivex.Observable

interface Remote {
    fun getAllCharacters(): Observable<CharactersRequest>
}