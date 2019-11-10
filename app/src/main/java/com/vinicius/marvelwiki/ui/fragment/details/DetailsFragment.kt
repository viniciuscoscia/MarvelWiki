package com.vinicius.marvelwiki.ui.fragment.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.domain.model.Character
import com.vinicius.marvelwiki.R
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment: Fragment() {

    val char by lazy {
        arguments?.getSerializable(MODEL_KEY) as Character
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvPrincipal.text = char.name
    }

    companion object {
        const val MODEL_KEY = "model_key"
    }
}