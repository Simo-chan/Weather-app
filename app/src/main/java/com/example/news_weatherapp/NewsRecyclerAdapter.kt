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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(newsData[position])


    inner class ViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        private val headline: TextView = itemView.findViewById(R.id.headline_of_news)
        private val description: TextView = itemView.findViewById(R.id.description_of_news)
        private val picture: ImageView = itemView.findViewById(R.id.picture_of_news)

        fun bind(news: NewsItems) {
            headline.text = news.headline
            description.text = news.description
            picture.setImageResource(news.picture)
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }

        }
    }
}