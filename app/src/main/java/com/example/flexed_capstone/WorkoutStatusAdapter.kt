package com.example.flexed_capstone

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.flexed_capstone.databinding.ItemWorkoutStatusBinding

class WorkoutStatusAdapter(private val data: ArrayList<WorkoutModel>): RecyclerView.Adapter<WorkoutStatusAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemWorkoutStatusBinding):RecyclerView.ViewHolder(binding.root){

        val statusTextView = binding.workoutNum
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWorkoutStatusBinding.inflate(LayoutInflater.from(parent.context)
            , parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.statusTextView.text = data[position].getId().toString()
       when {
            data[position].getIsChecked() -> {
                holder.statusTextView.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.circular_color_accent_border)
                holder.statusTextView.setTextColor(Color.parseColor("#212121"))
        }
            data[position].getIsFinished()-> {
                holder.statusTextView.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_accent_back)
                holder.statusTextView.setTextColor(Color.parseColor("#FFFFFF"))
        }else -> {
           holder.statusTextView.background =
               ContextCompat.getDrawable(holder.itemView.context, R.drawable.circular_color_gray_background)
           holder.statusTextView.setTextColor(Color.parseColor("#212121"))
        }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}