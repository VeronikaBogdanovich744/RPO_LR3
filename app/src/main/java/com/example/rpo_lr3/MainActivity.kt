package com.example.rpo_lr3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpo_lr3.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, MainFragment.newInstance())
                .commitNow()
        }
    }
}