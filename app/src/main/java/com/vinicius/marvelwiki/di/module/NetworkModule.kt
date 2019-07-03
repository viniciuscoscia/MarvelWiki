package com.vinicius.marvelwiki.di.module

import br.com.remote.service.IMarvelAPI
import br.com.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun getRetrofit() = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun getMarvelApi(retrofit: Retrofit) = retrofit.create(IMarvelAPI::class.java)
}