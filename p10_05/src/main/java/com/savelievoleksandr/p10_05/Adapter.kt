package com.savelievoleksandr.p10_05


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RandomPicksAdapter(private val items: List<RandomPicks>) :
    RecyclerView.Adapter<RandomPicksAdapter.RandomPicksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomPicksViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.picks, parent, false)
        return RandomPicksViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RandomPicksViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class RandomPicksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val photo1 = itemView.findViewById<ImageView>(R.id.photo1)
        private val name1 = itemView.findViewById<TextView>(R.id.name1TextView)
        private val photo2 = itemView.findViewById<ImageView>(R.id.photo2)
        private val name2 = itemView.findViewById<TextView>(R.id.name2TextView)
        private val percentage = itemView.findViewById<TextView>(R.id.percentageTextView)

        fun bind(picks: RandomPicks) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(picks.photo1)
                .circleCrop()
                .into(photo1)
            name1.text = picks.name1
            Glide.with(itemView.context)
                .asBitmap()
                .load(picks.photo2)
                .circleCrop()
                .into(photo2)
            name2.text = picks.name2
            percentage.text = picks.percentage
        }
    }
}