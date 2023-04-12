package com.example.news_weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class News : Fragment() {

    private lateinit var articleArray: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsList = mutableListOf<NewsItems>().apply {
            add(
                NewsItems(
                    R.drawable.gigachad,
                    getString(R.string.gigachad_headline),
                    getString(R.string.gigachad_description)
                )
            )
            add(
                NewsItems(
                    R.drawable.before_after_lips,
                    getString(R.string.lips_headline),
                    getString(R.string.lips_description)
                )
            )
            add(
                NewsItems(
                    R.drawable.cat_pic,
                    getString(R.string.cat_headline),
                    getString(R.string.cat_description)
                )
            )
            add(
                NewsItems(
                    R.drawable.increasing_p_size,
                    getString(R.string.pipi_headline),
                    getString(R.string.pipi_description)
                )
            )
            add(
                NewsItems(
                    R.drawable.sexy_milf,
                    getString(R.string.milf_headline),
                    getString(R.string.milf_description)
                )
            )
            add(
                NewsItems(
                    R.drawable.s_act_increase, getString(R.string.ointment_headline), getString(
                        R.string.ointment_description
                    )
                )
            )
            add(
                NewsItems(
                    R.drawable.troll_face_meme, getString(R.string.trollface_headline), getString(
                        R.string.trollface_descriptiom
                    )
                )
            )
            add(
                NewsItems(
                    R.drawable.kianu_at_park,
                    getString(R.string.kianu_headline),
                    getString(R.string.kianu_description)
                )
            )
        }

        articleArray = arrayOf(
            getString(R.string.gigachad_article),
            getString(R.string.lips_article),
            getString(R.string.cat_article),
            getString(R.string.pipi_article),
            getString(R.string.milf_article),
            getString(R.string.ointment_article),
            getString(R.string.trollface_article),
            getString(R.string.kianu_article),
        )

        val newsRecyclerAdapter = NewsRecyclerAdapter()
        newsRecyclerAdapter.newsData = newsList

        val recyclerView: RecyclerView = view.findViewById(R.id.news_recyclerView)
        recyclerView.adapter = newsRecyclerAdapter
        newsRecyclerAdapter.setOnItemClickListener(object :
            NewsRecyclerAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val bundle = Bundle().apply {
                    putString("headline", newsList[position].headline)
                    putInt("image", newsList[position].picture)
                    putString("article", articleArray[position])
                }

                val articleFragment = ArticleFragment()
                articleFragment.arguments = bundle

                val fragment = parentFragmentManager
                fragment.beginTransaction()
                    .addToBackStack("null")
                    .replace(R.id.nav_fragment, ArticleFragment())
                    .commit()
            }
        })
    }
}