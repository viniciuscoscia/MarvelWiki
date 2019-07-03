package com.vinicius.marvelwiki.api

import br.com.domain.model.CharactersRequest
import com.vinicius.marvelwiki.util.Constants
import com.vinicius.marvelwiki.util.toMD5
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

//ts - a timestamp (or other long string which can change on a request-by-request basis)
//hash - a md5 digest of the ts parameter, your private key and your public key (e.g. md5(ts+privateKey+publicKey)

//Marvel Public = e0fe067f70a2e3075d333cb6ecfd714d
//Marvel Private= 58c9909e091960b9406cfd0fa212e02aa6e8eee9

//https://gateway.marvel.com/v1/public/characters?name=hulk&ts=viniciusnunescoscia&apikey=e0fe067f70a2e3075d333cb6ecfd714d&hash=9f186c86e51579120acf1ef897e66d4c
//https://gateway.marvel.com/v1/public/characters?ts=1559181143706&apikey=e0fe067f70a2e3075d333cb6ecfd714d&hash=b04425270fdd539f37cc503fec0d48af
interface IMarvelAPI {

    @GET("characters")
    fun getAllCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Call<CharactersRequest>

    companion object {
        fun getHash() = (getTimeInMillis() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY).toMD5()

        fun getTimeInMillis(): String {
            return Calendar.getInstance().timeInMillis.toString()
        }
    }

}