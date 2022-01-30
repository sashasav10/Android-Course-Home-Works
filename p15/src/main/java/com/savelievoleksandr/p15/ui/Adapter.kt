package com.savelievoleksandr.p15.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.savelievoleksandr.p15.R
import com.savelievoleksandr.p15.data.model.ToDoListDbo

interface OnToDoListDboClick {
    fun onClick(userId: Int)
}

class Adapter(val listClick: OnToDoListDboClick) :
    ListAdapter<ToDoListDbo, Adapter.ViewHolder>(object : DiffUtil.ItemCallback<ToDoListDbo>() {
        override fun areItemsTheSame(oldItem: ToDoListDbo, newItem: ToDoListDbo): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ToDoListDbo, newItem: ToDoListDbo): Boolean =
            oldItem == newItem
    }) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.title)
        private val date: TextView = itemView.findViewById(R.id.date)
        private val counter: TextView = itemView.findViewById(R.id.counter)

        fun bind(item: ToDoListDbo, context: Context) {
            title.text = item.title
            date.text = item.date

            itemView.setOnClickListener {
                listClick.onClick(item.id - 1)
            }
        }
    }
}
