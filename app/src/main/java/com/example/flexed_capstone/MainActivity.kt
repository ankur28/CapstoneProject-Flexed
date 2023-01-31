package com.example.flexed_capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn : FrameLayout = findViewById(R.id.flStart)
        startBtn.setOnClickListener{
            Toast.makeText(this@MainActivity, "Start pressed",Toast.LENGTH_SHORT).show()
        }
    }
}