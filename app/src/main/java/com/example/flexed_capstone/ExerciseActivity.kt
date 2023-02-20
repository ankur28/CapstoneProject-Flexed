package com.example.flexed_capstone

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flexed_capstone.databinding.ActivityExerciseBinding
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var binding: ActivityExerciseBinding? = null
private var timerest: CountDownTimer? = null
    private var progresRest = 0

    private var exerciseTime : CountDownTimer? = null
    private var progExercise = 0

    //workout model
    private var workoutList:ArrayList<WorkoutModel>? = null
    private var currentWorkoutPosition = -1
     private var playerworkout: MediaPlayer? = null
    private var tts: TextToSpeech? = null

    private var workoutStatusAdapter: WorkoutStatusAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExerciseActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        //workout list
        workoutList= Constants.exerciseList()

        tts = TextToSpeech(this, this)
        binding?.toolbarExerciseActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        restSetup()
        setupWorkoutStatusRecyclerView()
    }
    private fun restSetup(){
        try{
            val soundU = Uri.parse("android.resource://com.example.flexed_capstone/" + R.raw.press_start)
            playerworkout = MediaPlayer.create(applicationContext, soundU)
            playerworkout?.isLooping = false
            playerworkout?.start()
        }catch (e: Exception){
            e.printStackTrace()
        }
            binding?.flProgress?.visibility = View.VISIBLE
            binding?.tvTitleTextView?.visibility =View.VISIBLE
            binding?.tvWorkout?.visibility= View.INVISIBLE
            binding?.flExercise?.visibility = View.INVISIBLE
            binding?.wimage?.visibility= View.INVISIBLE
            binding?.tvnextWorkout?.visibility=View.VISIBLE
            binding?.tvnextWorkoutName?.visibility=View.VISIBLE
            if(timerest != null){
                timerest?.cancel()
                progresRest = 0
            }
            binding?.tvnextWorkoutName?.text = workoutList!![currentWorkoutPosition +1].getName()
            setProBar()
    }


    private fun setupWorkoutStatusRecyclerView(){
        binding?.workoutStatusRecyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        workoutStatusAdapter = WorkoutStatusAdapter(workoutList!!)
        binding?.workoutStatusRecyclerView?.adapter = workoutStatusAdapter
    }
    private fun setupExercise(){
        binding?.flProgress?.visibility = View.INVISIBLE

        binding?.tvTitleTextView?.visibility =View.INVISIBLE
        binding?.tvWorkout?.visibility= View.VISIBLE
        binding?.flExercise?.visibility = View.VISIBLE

        binding?.wimage?.visibility= View.VISIBLE

        binding?.tvnextWorkout?.visibility=View.INVISIBLE
        binding?.tvnextWorkoutName?.visibility=View.INVISIBLE
        if(exerciseTime != null){
            exerciseTime?.cancel()
            progExercise=0
        }

        speakOutText(workoutList!![currentWorkoutPosition].getName())
        binding?.wimage?.setImageResource(workoutList!![currentWorkoutPosition].getPic())
        binding?.tvWorkout?.text = workoutList!![currentWorkoutPosition].getName()

        setExerciseBar()
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
                currentWorkoutPosition++
                workoutList!![currentWorkoutPosition].updateIsChecked(true)
                workoutStatusAdapter!!.notifyDataSetChanged()
                setupExercise()
            }
        }.start()
    }
    private fun setExerciseBar(){
        binding?.ProBarExercise?.progress = progExercise
        exerciseTime = object : CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                progExercise++
                 binding?.ProBarExercise?.progress = 30 - progExercise
                binding?.tvTimeExercise?.text = (30 - progExercise).toString()
            }

            override fun onFinish() {
                workoutList!![currentWorkoutPosition].updateIsFinished(true)
                workoutList!![currentWorkoutPosition].updateIsChecked(false)
                workoutStatusAdapter!!.notifyDataSetChanged()
                if (currentWorkoutPosition < workoutList?.size!! -1){
                    restSetup()
                }else{
                    Toast.makeText(
                        this@ExerciseActivity,
                        "Congrats! You have completed the workout",
                        Toast.LENGTH_SHORT
                    ).show()
                }
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

        if(tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }
        if(playerworkout != null){
            playerworkout!!.stop()
        }

        binding = null
    }

    override fun onInit(status: Int) {
       if( status == TextToSpeech.SUCCESS){
           val result = tts?.setLanguage(Locale.US)

           if(result == TextToSpeech.LANG_MISSING_DATA  || result == TextToSpeech.LANG_NOT_SUPPORTED){
               Log.e("TTS:","The language is not supported" )
           }
       }else {
           Log.e("TTS","Initialisation Failed")
       }
    }

    private fun speakOutText(text: String){
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
    }
}