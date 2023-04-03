package com.example.flexed_capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.flexed_capstone.databinding.ActivityLastBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class LastActivity : AppCompatActivity() {
    private var binding: ActivityLastBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.lastActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
binding?.lastActivity?.setNavigationOnClickListener{
    onBackPressed()

}
        binding?.LastBtn?.setOnClickListener{
            finish()
        }
        val Dao =(application as WorkoutApp).db.historyDao()
        addDate(Dao)
    }

    private fun addDate(historyDao: HistoryDao) {

        val cal = Calendar.getInstance()
        val Time = cal.time
        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        val dateF = sdf.format(Time)

        lifecycleScope.launch {
            withContext(Dispatchers.IO){ historyDao.
            insert(History(dateF))}

        }
    }
}