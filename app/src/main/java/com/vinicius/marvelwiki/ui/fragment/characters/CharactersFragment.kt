package com.vinicius.marvelwiki.ui.fragment.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.vinicius.marvelwiki.R
import com.vinicius.marvelwiki.commons.ContainerFragment
import com.vinicius.marvelwiki.ui.activity.main.GenericContainerAdapter
import com.vinicius.marvelwiki.ui.fragment.details.DetailsFragment
import com.vinicius.marvelwiki.viewModel.MainViewModel
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharactersFragment : ContainerFragment() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun setAdapter(): GenericContainerAdapter {
        return GenericContainerAdapter(
            requireActivity().applicationContext,
            onClickListener = { character ->
                val controller = findNavController()
                val dados = Bundle().apply {
                    putSerializable(DetailsFragment.MODEL_KEY, character)
                }
                controller.navigate(R.id.detailsFragment, dados)
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .subscribeBy(onNext = {
                myAdapter?.setCharacters(it)
            }, onError = {
                throw it
            })
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

}