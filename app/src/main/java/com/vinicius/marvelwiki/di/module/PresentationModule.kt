package com.vinicius.marvelwiki.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinicius.marvelwiki.commons.BaseFragment
import com.vinicius.marvelwiki.ui.activity.main.MainActivity
import com.vinicius.marvelwiki.ui.fragment.characters.CharactersFragment
import com.vinicius.marvelwiki.viewModel.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlin.reflect.KClass

@Module
abstract class PresentationModule {

    @ContributesAndroidInjector
    abstract fun contruibutesMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contruibutesCharactersFragment(): CharactersFragment

    @ContributesAndroidInjector
    abstract fun contruibutesBaseFragment(): BaseFragment

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

//Definindo a anotação do ViewModel
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)