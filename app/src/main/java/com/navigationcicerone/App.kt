package com.navigationcicerone

import android.app.Application
import com.navigationcicerone.di.AppComponent
import com.navigationcicerone.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().build()
    }
}