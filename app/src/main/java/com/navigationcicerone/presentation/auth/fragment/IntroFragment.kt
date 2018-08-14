package com.androidnavigation.auth.fragment

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.navigationcicerone.App
import com.navigationcicerone.R
import com.navigationcicerone.domain.keys.Screens
import com.navigationcicerone.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_intro.view.*


class IntroFragment : BaseFragment() {

    override fun injectDependencies() {
        App.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.fragment_intro, container, false)
        view.helloButton.setOnClickListener({
            localRouter.replaceScreen(Screens.SIGN_IN.name)
        })
        return view
    }
}