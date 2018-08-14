package com.androidnavigation.auth.fragment

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidnavigation.main.MainActivity
import com.navigationcicerone.App
import com.navigationcicerone.R
import com.navigationcicerone.domain.keys.Screens
import com.navigationcicerone.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_sign_up.view.*


class SignUpFragment : BaseFragment() {
    override fun injectDependencies() {
        App.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        view.backButton.setOnClickListener({
            localRouter.backTo(Screens.SIGN_IN.name)
        })
        view.signUpButton.setOnClickListener({
           globalRouter.navigateTo(Screens.MAIN.name)
        })
        return view
    }
}