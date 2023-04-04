package com.example.flexed_capstone

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert
     fun insert(historyEntity: History): Long

     @Query("SELECT * FROM history_table")
     fun fetchAllDates(): Flow<List<History>>
}