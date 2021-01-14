package com.example.bottomnavigationview

import android.app.Application

class App : Application() {
    companion object {
        lateinit var prefs : MysharedPreferences
    }

    override fun onCreate() {
        prefs = MysharedPreferences(applicationContext)
        super.onCreate()
    }
}