package com.example.thoughtapp

import android.app.Application
import com.example.thoughtapp.di.AppContainer
import com.example.thoughtapp.di.AppDataContainer

class ThoughtsApplication : Application() {
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}