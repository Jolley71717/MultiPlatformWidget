package com.example.forthewidgets.utils

import android.app.Application

class MainActivity : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MainActivity
            private set
    }
}