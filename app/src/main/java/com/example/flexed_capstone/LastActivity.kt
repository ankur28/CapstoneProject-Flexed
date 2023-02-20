package com.example.flexed_capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flexed_capstone.databinding.ActivityLastBinding

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
    }
}