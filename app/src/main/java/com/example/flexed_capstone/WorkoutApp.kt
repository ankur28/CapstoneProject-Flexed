package com.example.flexed_capstone

import android.app.Application

class WorkoutApp:Application() {
    val db by lazy {
        HistoryDb.getInstance(this)
    }
}