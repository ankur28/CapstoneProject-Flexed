package com.example.flexed_capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flexed_capstone.databinding.ActivityWorkoutPreviewBinding
import com.example.flexed_capstone.databinding.ActivityWorkoutTypeBinding
import java.io.Serializable

class WorkoutPreview : AppCompatActivity(), Serializable {

    private var binding: ActivityWorkoutPreviewBinding? = null
    private var workoutList:ArrayList<WorkoutModel>? = null
    private var workoutPreviewAdapter: WorkoutPreviewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutPreviewBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        window.statusBarColor = getColor(R.color.colorAccent)

        setSupportActionBar(binding?.toolbarWorkoutPreviewActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarWorkoutPreviewActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        var  tag: Int = intent.getIntExtra("tag",0)
        when(tag){
            1 -> {
                workoutList = intent.getSerializableExtra("beginnerList") as ArrayList<WorkoutModel>
            }
            2 -> {
                workoutList = intent.getSerializableExtra("intermediateList") as ArrayList<WorkoutModel>
            }
            3 -> {
                workoutList = intent.getSerializableExtra("advancedList") as ArrayList<WorkoutModel>
            }
        }

        binding?.workoutPreviewAdpater?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        workoutPreviewAdapter = WorkoutPreviewAdapter(workoutList!!)
        binding?.workoutPreviewAdpater?.adapter = workoutPreviewAdapter

        binding?.startWorkout?.setOnClickListener{
            val intent = Intent(this, ExerciseActivity::class.java)
            intent.putExtra("dataList", workoutList as Serializable)
            startActivity(intent)
        }
    }
}