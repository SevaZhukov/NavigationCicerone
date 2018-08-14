package com.navigationcicerone.domain

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import com.androidnavigation.auth.fragment.IntroFragment
import com.androidnavigation.auth.fragment.SignInFragment
import com.androidnavigation.auth.fragment.SignUpFragment
import com.androidnavigation.main.fragment.NewsFragment
import com.androidnavigation.main.fragment.PostFragment
import com.androidnavigation.main.fragment.SettingsFragment
import com.navigationcicerone.domain.keys.Containers
import com.navigationcicerone.domain.keys.Screens
import ru.terrakok.cicerone.android.FragmentNavigator

class LocalNavigator(var fragmentManager: FragmentManager, var containerId: Int) : FragmentNavigator(fragmentManager, containerId) {

    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        return when (containerId) {
            Containers.MAIN.id -> mainFragment(screenKey, data)
            Containers.AUTH.id -> authFragment(screenKey, data)
            else -> mainFragment(screenKey, data)
        }
    }

    private fun authFragment(screenKey: String?, data: Any?): Fragment {
        return when (screenKey) {
            Screens.INTRO.name -> IntroFragment()
            Screens.SIGN_IN.name -> SignInFragment()
            Screens.SIGN_UP.name -> SignUpFragment()
            else -> SignInFragment()
        }
    }

    private fun mainFragment(screenKey: String?, data: Any?): Fragment {
        val bundle = Bundle()
        return when (screenKey) {
            Screens.POST.name -> {
                bundle.putString("id", data as String?)
                val postFragment = PostFragment()
                postFragment.arguments = bundle
                postFragment
            }
            Screens.NEWS.name -> NewsFragment()
            Screens.SETTINGS.name -> SettingsFragment()
            else -> NewsFragment()

        }
    }

    override fun showSystemMessage(message: String?) {
    }

    override fun exit() {
    }
}