package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragmentHome by lazy { HomeFragment()}
    private val fragmentSearch by lazy { SearchFragment()}
    private val fragmentSubscribe by lazy { SubscribeFragment()}
    private val fragmentVideobox by lazy { VideoboxFragment()}


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }


    override fun onResume() {
        super.onResume()
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnMain1.setOnClickListener {
            Toast.makeText(this, "button1 is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnMain2.setOnClickListener {
            Toast.makeText(this, "button2 is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnMain3.setOnClickListener {
            Toast.makeText(this, "button3 is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnMain4.setOnClickListener {
            Toast.makeText(this, "button4 is clicked", Toast.LENGTH_SHORT).show()
        }

//        setSupportActionBar(binding.myToolbar)
        setContentView(binding.root)

        initNavigationBar()
    }

    private fun initNavigationBar() {
        binding.bnvMain.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.first -> {
                        changeFragment(fragmentHome)
                    }
                    R.id.second -> {
                        changeFragment(fragmentSearch)
                    }
                    R.id.third -> {
                        changeFragment(fragmentSubscribe)
                    }
                    R.id.fourth -> {
                        changeFragment(fragmentVideobox)
                    }
                }
                true
            }
            selectedItemId = R.id.first
        }

    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val menuInflater = menuInflater
//        menuInflater.inflate(R.menu.appbar_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.getItemId()) {
//            R.id.action_btn1 -> {
//                Toast.makeText(this, "button1 is clicked", Toast.LENGTH_SHORT).show()
//                return true
//            }
//            R.id.action_btn2 -> {
//                Toast.makeText(this, "button2 is clicked", Toast.LENGTH_SHORT).show()
//                return true
//            }
//            R.id.action_btn3 -> {
//                Toast.makeText(this, "button3 is clicked", Toast.LENGTH_SHORT).show()
//                return true
//            }
//            R.id.action_btn4 -> {
//                Toast.makeText(this, "button4 is clicked", Toast.LENGTH_SHORT).show()
//                return true
//            }
//            else -> {
//                return super.onOptionsItemSelected(item)
//            }
//        }
//    }
}