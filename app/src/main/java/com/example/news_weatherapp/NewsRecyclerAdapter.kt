package com.example.news_weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsRecyclerAdapter : RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder>() {

    private lateinit var itemListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemListener = listener
    }

    var newsData = emptyList<NewsItems>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_items_recyclerview, parent, false)
        return ViewHolder(itemView, itemListener)
    }

    override fun getItemCount(): Int {
        return newsData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = newsData[position]
        holder.picture.setImageResource(currentItem.picture)
        holder.headline.text = currentItem.headline
        holder.description.text = currentItem.description
    }


    inner class ViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val headline: TextView = itemView.findViewById(R.id.headline_of_news)
        val description: TextView = itemView.findViewById(R.id.description_of_news)
        val picture: ImageView = itemView.findViewById(R.id.picture_of_news)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }

        }
    }
}