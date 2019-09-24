package br.com.remote.service

import MarvelWiki.remote.BuildConfig
import br.com.domain.model.CharactersRequest
import br.com.utils.Constants
import br.com.utils.toMD5
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface IMarvelAPI {

    @GET("characters")
    fun getAllCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Observable<CharactersRequest>

    companion object {
        fun getHash(time: String, privateKey: String) = (time + privateKey + BuildConfig.API_PUBLIC_KEY).toMD5()

        fun getTimeInMillis(): String {
            return Calendar.getInstance().toString()
        }
    }

}