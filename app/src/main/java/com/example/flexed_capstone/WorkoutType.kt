package com.example.flexed_capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flexed_capstone.databinding.ActivityWorkoutTypeBinding
import java.io.Serializable

class   WorkoutType : AppCompatActivity(), Serializable {
    private var binding: ActivityWorkoutTypeBinding? = null
    private var intermediateWorkoutList:ArrayList<WorkoutModel>? = null
    private var advancedWorkoutList:ArrayList<WorkoutModel>? = null
    private var beginnerWorkoutList:ArrayList<WorkoutModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutTypeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        window.statusBarColor = getColor(R.color.colorAccent)

        setSupportActionBar(binding?.toolbarWorkoutTypeActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarWorkoutTypeActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        beginnerWorkoutList = Constants.beginnerExerciseList()

        binding?.beginnerView?.setOnClickListener{
            val intent = Intent(this, WorkoutPreview::class.java)
            intent.putExtra("beginnerList", beginnerWorkoutList as Serializable)
            intent.putExtra("tag",1)
            startActivity(intent)

        }

        intermediateWorkoutList = Constants.intermediateExerciseList()
        binding?.intermediateView?.setOnClickListener{
            val intent = Intent(this, WorkoutPreview::class.java)
            intent.putExtra("intermediateList", intermediateWorkoutList as Serializable)
            intent.putExtra("tag",2)
            startActivity(intent)

        }

        advancedWorkoutList = Constants.advancedExerciseList()
        binding?.advancedView?.setOnClickListener{
            val intent = Intent(this, WorkoutPreview::class.java)
            intent.putExtra("advancedList", advancedWorkoutList as Serializable)
            intent.putExtra("tag",3)
            startActivity(intent)

        }

    }

}