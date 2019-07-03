package com.vinicius.marvelwiki.di.module

import br.com.data.repository.Remote
import br.com.remote.RemoteImpl
import br.com.remote.service.IMarvelAPI
import br.com.remote.service.RetrofitServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {
//    @Singleton
//    @Provides
//    fun getRetrofit(): Retrofit = Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//    @Singleton
//    @Provides
//    fun getMarvelApi(retrofit: Retrofit): IMarvelAPI = retrofit.create(IMarvelAPI::class.java)

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideRetrofitService(): IMarvelAPI {
            return RetrofitServiceFactory.makeRetrofitService()
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemote: RemoteImpl): Remote
}