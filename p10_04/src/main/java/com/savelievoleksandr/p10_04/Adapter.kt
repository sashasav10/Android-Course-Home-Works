package com.savelievoleksandr.p10_04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionsAdapter(private val items: List<Transaction>) :
    RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction, parent, false)
        return TransactionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val from = itemView.findViewById<TextView>(R.id.fromTextView)
        private val date = itemView.findViewById<TextView>(R.id.dateTextView)
        private val balance = itemView.findViewById<TextView>(R.id.balanceTextView)
        private val sum = itemView.findViewById<TextView>(R.id.sumTextView)

        fun bind(transaction: Transaction) {
            from.text = transaction.from
            date.text = transaction.date
            sum.text = transaction.sum.toString()
            balance.text = transaction.balance.toString()
        }
    }
}