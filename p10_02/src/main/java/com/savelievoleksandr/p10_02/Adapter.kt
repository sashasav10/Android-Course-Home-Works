package com.savelievoleksandr.p10_02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrdersAdapter(private val items: List<Orders>) :
    RecyclerView.Adapter<OrdersAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.orders, parent, false)
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.nameTextView)
        private val address = itemView.findViewById<TextView>(R.id.addressTextView)
        private val content = itemView.findViewById<TextView>(R.id.contentTextView)
        private val price = itemView.findViewById<TextView>(R.id.priceTextView)

        fun bind(orders: Orders) {
            name.text = orders.name
            address.text = orders.address
            content.text = orders.content
            price.text = orders.sum.toString()
        }
    }

}