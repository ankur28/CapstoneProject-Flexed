package com.example.flexed_capstone

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.flexed_capstone.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    private var binding: ActivityBmiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarActivityBmi)

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "CALCULATE BMI"
        }
        binding?.toolbarActivityBmi?.setNavigationOnClickListener {
            onBackPressed()
        }
        binding?.bmicalcunit?.setOnClickListener{
            if (validatevalue()){
                val heightval: Float = binding?.edHeight?.text.toString().toFloat()/100
                val weightval : Float =binding?.edWeight?.text.toString().toFloat()
                val bmi = weightval/(heightval*heightval)
                displayresult(bmi)
            }else{
                Toast.makeText(this@BMIActivity,
                    "Please enter valid values",Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private fun displayresult (bmi:Float){
        val label: String
        val desc :String

        if (bmi.compareTo(15f)<=0){
            label = "Very severely underweight"
            desc = "Oops! You really need to take better care of yourself! Eat more!"
        }else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f)<=0){
            label = "Severely underweight"
            desc = "Oops! You really need to take better care of yourself! Eat more!"
        }else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f)<=0){
            label = "Underweight"
            desc = "Oops! You really need to take better care of yourself! Eat more!"
        }else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f)<=0){
            label = "Normal"
            desc = "Congratulations! You are in a good shape!"
        }else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f)<=0){
            label = "Overweight"
            desc = "Oops! You really need to take care of your yourself! Workout "
        }else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f)<=0){
            label = "Obese class | (Moderately obsese)"
            desc = "Oops! You really need to take care of your yourself! Workout "
        }else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f)<=0){
            label = "Obese class || (Severely obsese)"
            desc =  "OMG! You are in a very dangerous condition! Act now!"
        }else{
            label = "Obese class |||(Very Severely obsese)"
            desc =  "OMG! You are in a very dangerous condition! Act now!"
        }



        binding?.bmiResult?.visibility = View.VISIBLE
        binding?.tvBMIvalue?.text = BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
        binding?.tvBMItype?.text = label
        binding?.tvBMIdescription?.text =desc

    }

    private fun validatevalue():Boolean{
        var isValid = true
        if (binding?.edWeight?.text.toString().isEmpty()){
            isValid = false
        }else if (binding?.edHeight?.text.toString().isEmpty()){
            isValid = false
        }
        return isValid
    }
}