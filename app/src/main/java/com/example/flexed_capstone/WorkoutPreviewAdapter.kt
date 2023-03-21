package com.example.flexed_capstone

import com.example.flexed_capstone.databinding.ItemWorkoutPreviewBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class WorkoutPreviewAdapter(private val data: ArrayList<WorkoutModel>): RecyclerView.Adapter<WorkoutPreviewAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemWorkoutPreviewBinding):RecyclerView.ViewHolder(binding.root){

        val workoutTextView = binding.workoutTypeText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWorkoutPreviewBinding.inflate(LayoutInflater.from(parent.context)
            , parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.workoutTextView.text = "• " + data[position].getName()
    }

    override fun getItemCount(): Int {
        return data.size
    }

}