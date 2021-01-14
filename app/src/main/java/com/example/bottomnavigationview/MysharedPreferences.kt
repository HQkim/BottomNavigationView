package com.example.bottomnavigationview

import android.content.Context
import android.content.SharedPreferences

class MysharedPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("prefs",  0)

    fun getString(key: String?, defValue: String?): String? {
        return prefs.getString(key, "").toString()
    }

    fun setString(key: String?, str:String?) {
        prefs.edit().putString(key, str).apply()
    }

}