package com.example.bottomnavigationview

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StartActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Toast.makeText(this, "Start_onCreate", Toast.LENGTH_SHORT).show()

        SystemClock.sleep(500)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}