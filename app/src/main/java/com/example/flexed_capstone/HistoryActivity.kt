package com.example.flexed_capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flexed_capstone.databinding.ActivityHistoryBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private var binding: ActivityHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarHistoryActivity)

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "HISTORY"
        }
        binding?.toolbarHistoryActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        val historyDao = (application as WorkoutApp).db.historyDao()
        getAllDates(historyDao)
    }

    private fun getAllDates(historyDao: HistoryDao){
        lifecycleScope.launch{
            historyDao.fetchAllDates().collect() { allDatesList ->
                if (allDatesList.isNotEmpty()){
                    binding?.textView6?.visibility = View.VISIBLE
                    binding?.datesAdapter?.visibility = View.VISIBLE
                    binding?.noDataTv?.visibility = View.INVISIBLE

                    binding?.datesAdapter?.layoutManager = LinearLayoutManager(this@HistoryActivity)
                    val dates = ArrayList<String>()
                    for(date in allDatesList){
                        dates.add(date.date)
                    }
                    val workoutHistoryAdapter = WorkoutHistoryAdapter(dates)
                    binding?.datesAdapter?.adapter = workoutHistoryAdapter
                }
                else{
                    binding?.textView6?.visibility = View.INVISIBLE
                    binding?.datesAdapter?.visibility = View.INVISIBLE
                    binding?.noDataTv?.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}