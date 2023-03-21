package com.example.flexed_capstone

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.flexed_capstone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        window.statusBarColor = getColor(R.color.colorAccent)
        //val startBtn : FrameLayout = findViewById(R.id.flStart)
//        val anim = AnimationUtils.loadAnimation(applicationContext,androidx.appcompat.R.anim.abc_popup_enter)
//        binding?.flbackgorund?.startAnimation(anim)
        binding?.flStart?.setOnClickListener{
            val intent = Intent(this, WorkoutType::class.java)
            startActivity(intent)

        }
        binding?.checkbmi?.setOnClickListener{
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}