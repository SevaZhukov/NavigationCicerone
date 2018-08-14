package com.androidnavigation.auth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidnavigation.auth.fragment.IntroFragment
import com.androidnavigation.main.MainActivity
import com.navigationcicerone.App
import com.navigationcicerone.R
import com.navigationcicerone.di.qualifier.Local
import com.navigationcicerone.domain.keys.Screens
import com.navigationcicerone.presentation.base.BaseActivity
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AuthActivity : BaseActivity() {

    override fun injectDependencies() {
        App.component.inject(this)
    }

    override fun getContainerId(): Int {
        return R.id.auth_container
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        if (isSignedIn()) {
            globalRouter.navigateTo(Screens.MAIN.name)
        } else {
            localRouter.newRootScreen(Screens.INTRO.name)
        }
    }

    fun isSignedIn(): Boolean {
        return false
    }
}