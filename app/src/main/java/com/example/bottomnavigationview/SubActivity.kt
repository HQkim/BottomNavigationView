package com.example.bottomnavigationview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.widget.MediaController
import android.widget.Toast
import com.example.bottomnavigationview.R
import com.example.bottomnavigationview.databinding.ActivitySubBinding


class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Toast.makeText(this, "Sub_onCreate", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this, "Sub_onResume", Toast.LENGTH_SHORT).show()

        val video =intent.getStringExtra("video_name")
//        var character:Char? = video?.get(0) //intent.getStringExtra에서 Char로 바꿔주었다.

        binding = ActivitySubBinding.inflate(layoutInflater)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)

        var offlineUri = Uri.parse("android.resource://$packageName/${R.raw.video1}")

//        when (video) {
//            "1" -> {offlineUri = Uri.parse("android.resource://$packageName/${R.raw.video1}")
//                App.prefs.setString("first_1", "1")
//            }
//            "2" -> {offlineUri = Uri.parse("android.resource://$packageName/${R.raw.video2}")
//                App.prefs.setString("first_2", "1")
//            }
//            "3" -> {offlineUri = Uri.parse("android.resource://$packageName/${R.raw.video3}")
//                App.prefs.setString("first_3", "1")
//            }
//            "4" -> {offlineUri = Uri.parse("android.resource://$packageName/${R.raw.video4}")
//                App.prefs.setString("first_4", "1")
//            }
//        }

        setContentView(binding.root) // 아 이걸 해줘야 한다.
        binding.videoView.setMediaController(mediaController)
        binding.videoView.setVideoURI(offlineUri)
        binding.videoView.requestFocus()
        binding.videoView.start()


        binding.btnSub1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
//        Toast.makeText(this, "Sub_onPause", Toast.LENGTH_SHORT).show()
        binding.videoView.pause()
        Log.d("tag", "video is paused")
    }

    override fun onStop() {
        super.onStop()
//        Toast.makeText(this, "Sub_onStop", Toast.LENGTH_SHORT).show()
        binding.videoView.stopPlayback()

    }

    override fun onDestroy() {
        super.onDestroy()
//        Toast.makeText(this, "Sub_onDestroy", Toast.LENGTH_SHORT).show()
    }

}