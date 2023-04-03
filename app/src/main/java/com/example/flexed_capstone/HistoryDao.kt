package com.example.flexed_capstone

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface HistoryDao {

    @Insert
     fun insert(historyEntity: History): Long
}