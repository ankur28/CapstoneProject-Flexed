package com.example.flexed_capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.flexed_capstone.databinding.ActivityExerciseBinding
import com.example.flexed_capstone.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding: ActivityExerciseBinding? = null
private var timerest: CountDownTimer? = null
    private var progresRest = 0

    private var exerciseTime : CountDownTimer? = null
    private var progExercise = 0
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
restSetup()
    }
    private fun restSetup(){
        if(timerest != null){
            timerest?.cancel()
            progresRest = 0
        }
        setProBar()
    }

    private fun setuoExcercise(){
        binding?.flProgress?.visibility = View.INVISIBLE
        binding?.tvTitleTextView?.text= "Exercise Name"
        binding?.flExercise?.visibility = View.VISIBLE
        if(exerciseTime != null){
            exerciseTime?.cancel()
            progExercise=0
        }
        setExcerciseBar()
    }
    private fun setProBar(){
        binding?.ProBar?.progress = progresRest
        timerest = object : CountDownTimer(10000, 1000){
            override fun onTick(p0: Long) {
               progresRest++
                binding?.ProBar?.progress = 10 - progresRest
                binding?.tvTime?.text = (10 - progresRest).toString()
            }

            override fun onFinish() {
              setuoExcercise()
            }
        }.start()
    }
    private fun setExcerciseBar(){
        binding?.ProBarExercise?.progress = progExercise
        exerciseTime = object : CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                progExercise++
                binding?.ProBarExercise?.progress = 30 - progExercise
                binding?.tvTimeExercise?.text = (30 - progExercise).toString()
            }

            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "30 Seconds are over, lets go to the rest view",
                    Toast.LENGTH_SHORT

                ).show()
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(timerest != null){
            timerest?.cancel()
            progresRest = 0
        }
        if(exerciseTime != null){
            exerciseTime?.cancel()
            progExercise=0
        }
        binding = null
    }
}