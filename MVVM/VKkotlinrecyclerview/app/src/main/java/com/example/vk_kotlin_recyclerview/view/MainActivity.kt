package com.example.vk_kotlin_recyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.vk_kotlin_recyclerview.R
import com.example.vk_kotlin_recyclerview.model.Database
import com.example.vk_kotlin_recyclerview.model.News
import com.example.vk_kotlin_recyclerview.view_model.NewsListViewModel
import com.example.vk_kotlin_recyclerview.view_model.ViewModelProviderFactory

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.RecyclerViewItemClick {

    lateinit var recyclerView : RecyclerView
    private var newsAdapter: RecyclerViewAdapter? = null

    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private lateinit var newsListViewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelProviderFactory = ViewModelProviderFactory(context = this)
        newsListViewModel = ViewModelProvider(this, viewModelProviderFactory)
            .get(NewsListViewModel::class.java)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            newsListViewModel.getNews()
        }

        newsAdapter = RecyclerViewAdapter(itemClickListener = this)
        recyclerView.adapter = newsAdapter

        newsListViewModel.getNews()
        newsListViewModel.liveData.observe(this, Observer { result ->
            when (result) {
                is NewsListViewModel.State.ShowLoading -> {
                    swipeRefreshLayout.isRefreshing = true
                }
                is NewsListViewModel.State.HideLoading -> {
                    swipeRefreshLayout.isRefreshing = false
                }
                is NewsListViewModel.State.Result -> {
                    newsAdapter?.list = result.list
                    newsAdapter?.notifyDataSetChanged()
                }
            }
        })


    }

    override fun itemClick(position: Int, item: News)  {
        val intent = Intent(this, NewsDetailActivity::class.java)
        intent.putExtra("news", item)
        startActivity(intent)
    }

}
