package com.savelievoleksandr.p15.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.savelievoleksandr.p15.R
import com.savelievoleksandr.p15.data.model.TaskDbo

interface OnTaskDboClick {
    fun onClick(userId: Int)
}

class TaskAdapter(val taskClick: OnTaskDboClick) :
    ListAdapter<TaskDbo, Adapter.ViewHolder>(object : DiffUtil.ItemCallback<TaskDbo>() {
        override fun areItemsTheSame(oldItem: TaskDbo, newItem: TaskDbo): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TaskDbo, newItem: TaskDbo): Boolean =
            oldItem == newItem
    }) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskName: TextView = itemView.findViewById(R.id.taskName)
        private val isChecked :CheckBox= itemView.findViewById(R.id.taskCheckBox)

        fun bind(item: TaskDbo, context: Context) {
            taskName.text = item.name
            //isChecked.text=item.isChecked

            itemView.setOnClickListener {
                taskClick.onClick(item.id - 1)
            }
        }
    }
}
