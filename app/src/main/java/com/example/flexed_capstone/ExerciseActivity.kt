package com.example.flexed_capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flexed_capstone.databinding.ActivityExerciseBinding
import com.example.flexed_capstone.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding: ActivityExerciseBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExerciseActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExerciseActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}