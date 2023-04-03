package com.example.flexed_capstone

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "history_table")
data class History  (
    @PrimaryKey
    val date: String
)