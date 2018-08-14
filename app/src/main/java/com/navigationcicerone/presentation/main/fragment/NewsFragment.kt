package com.androidnavigation.main.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.navigationcicerone.App
import com.navigationcicerone.R
import com.navigationcicerone.domain.keys.Screens
import com.navigationcicerone.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment : BaseFragment() {
    override fun injectDependencies() {
        App.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        view.postButton.setOnClickListener({
            localRouter.navigateTo(Screens.POST.name, "1")
        })
        return view
    }
}