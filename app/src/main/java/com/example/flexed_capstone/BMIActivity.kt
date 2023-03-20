package com.example.flexed_capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.flexed_capstone.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    companion object {
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
        private const val US_UNITS_VIEW = "US_UNIT_VIEW"
    }
    private var currentVisibleView: String = METRIC_UNITS_VIEW
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
        makeVisibleMetricUnitsView()
        binding?.rgUnits?.setOnCheckedChangeListener { _, checkedId: Int ->


            if (checkedId == R.id.rbMetricUnits) {
                makeVisibleMetricUnitsView()
            } else {
                makeVisibleUsUnitsView()
            }
        }
        binding?.bmicalcunit?.setOnClickListener{
            calculateUnits()
        }
    }
    private fun makeVisibleMetricUnitsView() {
        currentVisibleView = METRIC_UNITS_VIEW
        binding?.tilWeight?.visibility = View.VISIBLE
        binding?.tilHeight?.visibility = View.VISIBLE
        binding?.tilUsUnitWeight?.visibility = View.GONE
        binding?.tilUsFeet?.visibility = View.GONE
        binding?.tilUsInch?.visibility = View.GONE
        binding?.edHeight?.text!!.clear()
        binding?.edWeight?.text!!.clear()
        binding?.bmiResult?.visibility = View.INVISIBLE
    }
    private fun makeVisibleUsUnitsView() {
        currentVisibleView = US_UNITS_VIEW
        binding?.tilHeight?.visibility = View.INVISIBLE
        binding?.tilWeight?.visibility = View.INVISIBLE
        binding?.tilUsUnitWeight?.visibility = View.VISIBLE
        binding?.tilUsFeet?.visibility =
            View.VISIBLE
        binding?.tilUsInch?.visibility =
            View.VISIBLE

        binding?.etUsMetricUnitWeight?.text!!.clear()
        binding?.edUsHeightFeet?.text!!.clear()
        binding?.edUsHeightInch?.text!!.clear()

        binding?.bmiResult?.visibility = View.INVISIBLE
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

    private fun calculateUnits(){

        if (currentVisibleView == METRIC_UNITS_VIEW) {

            if (validatevalue()) {
                val heightValue: Float = binding?.edHeight?.text.toString().toFloat() / 100


                val weightValue: Float = binding?.edWeight?.text.toString().toFloat()
                val bmi = weightValue / (heightValue * heightValue)

                displayresult(bmi)
            } else {
                Toast.makeText(
                    this@BMIActivity,
                    "Please enter valid values.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        } else {

            if (validateValueUs()) {

                val usUnitHeightValueFeet: String =
                    binding?.edUsHeightFeet?.text.toString()
                val usUnitHeightValueInch: String =
                    binding?.edUsHeightInch?.text.toString()
                val usUnitWeightValue: Float = binding?.etUsMetricUnitWeight?.text.toString()
                    .toFloat()

                val heightValue =
                    usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12

                val bmi = 703 * (usUnitWeightValue / (heightValue * heightValue))

                displayresult(bmi)
            } else {
                Toast.makeText(
                    this@BMIActivity,
                    "Please enter valid values.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
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
    private fun validateValueUs(): Boolean {
        var isValid = true

        when {
            binding?.etUsMetricUnitWeight?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.edUsHeightFeet?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.edUsHeightInch?.text.toString().isEmpty() -> {
                isValid = false
            }
        }

        return isValid
    }
}