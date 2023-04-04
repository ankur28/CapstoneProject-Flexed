package com.example.flexed_capstone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.flexed_capstone.databinding.WorkoutHistoryRowBinding

class WorkoutHistoryAdapter(private val items: ArrayList<String>): RecyclerView.Adapter<WorkoutHistoryAdapter.ViewHolder>() {

    class ViewHolder(binding: WorkoutHistoryRowBinding): RecyclerView.ViewHolder(binding.root){
        val wkoutHistorylayout = binding.datesRowLayout
        val textViewPosition = binding.textView
        val textViewDate = binding.textViewDate

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(WorkoutHistoryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val date:String = items.get(position)
        holder.textViewPosition.text = (position + 1).toString()
        holder.textViewDate.text = date

        if( position % 2 == 0){
            holder.wkoutHistorylayout.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.lightGray))
        }else{
            holder.wkoutHistorylayout.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))

        }
    }
}