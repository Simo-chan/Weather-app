package com.example.news_weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ArticleFragment : Fragment() {
    private lateinit var heading: String
    private var image: Int = 0
    private lateinit var articleText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            heading = it.getString("headline", "")
            image = it.getInt("image", 0)
            articleText = it.getString("article", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)

        val articleHeadline = view.findViewById<TextView>(R.id.article_name)
        articleHeadline.text = heading

        val articleImage = view.findViewById<ImageView>(R.id.article_image)
        articleImage.setImageResource(image)

        val articleContent = view.findViewById<TextView>(R.id.article_text)
        articleContent.text = articleText

        return view
    }
}