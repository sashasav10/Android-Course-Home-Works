package com.savelievoleksandr.p10_03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AccountsAdapter(private val items: List<Account>) :
    RecyclerView.Adapter<AccountsAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.account, parent, false)
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.nameTextView)
        private val currency = itemView.findViewById<TextView>(R.id.currencyTextView)
        private val cardNumber = itemView.findViewById<TextView>(R.id.CardNumberTextView)
        private val sum = itemView.findViewById<TextView>(R.id.sumTextView)

        fun bind(order: Account) {
            name.text = order.name
            currency.text = order.currency
            cardNumber.text = order.cardNumber
            sum.text = order.sum.toString()
        }
    }

}