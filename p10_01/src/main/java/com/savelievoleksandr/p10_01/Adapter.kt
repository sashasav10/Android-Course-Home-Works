package com.savelievoleksandr.p10_01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotosAdapter(private val items: List<Photos>) :
    RecyclerView.Adapter<PhotosAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.photos, parent, false)
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val photo = itemView.findViewById<ImageView>(R.id.photo)
        private val likes = itemView.findViewById<TextView>(R.id.likesCountTextView)
        private val description = itemView.findViewById<TextView>(R.id.descriptionTextView)

        fun bind(photos: Photos) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(photos.photo)
                .circleCrop()
                .into(photo)

            likes.text = photos.likes.toString()
            description.text = photos.description
        }
    }

}