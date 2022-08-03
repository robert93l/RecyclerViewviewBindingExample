package com.example.recyclerviewviewbindingexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewviewbindingexample.databinding.RecyclerviewItemBinding

class MainAdapter(val taskList: List<Task>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun binding(task: Task) {
            binding.titleTv.text = task.title
            binding.timeTv.text = task.timestamp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task = taskList[position]
        holder.binding(task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}