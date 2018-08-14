package com.androidnavigation.main

import android.app.Fragment
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import com.androidnavigation.main.fragment.*
import com.navigationcicerone.App
import com.navigationcicerone.R
import com.navigationcicerone.domain.keys.Screens
import com.navigationcicerone.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.nav_header.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {
    override fun getContainerId(): Int {
        return R.id.main_container
    }

    override fun injectDependencies() {
        App.component.inject(this)
    }

    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDrawerContent()
        setSupportActionBar(toolbar)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)

        localRouter.newRootScreen(Screens.NEWS.name)

        val header = navView.getHeaderView(0)
        header.shareButton.setOnClickListener({})
    }

    private fun setupDrawerContent() {
        navView.setCheckedItem(0)
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_news -> localRouter.newRootScreen(Screens.NEWS.name)
                R.id.nav_settings -> localRouter.newRootScreen(Screens.SETTINGS.name)
                else -> localRouter.newRootScreen(Screens.NEWS.name)
            }
            menuItem.isChecked = true
            title = menuItem.title
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }
}
