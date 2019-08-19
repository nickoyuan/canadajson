package com.testapp.nick.canadajson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.testapp.nick.canadajson.adapter.CanadaRecyclerAdapter
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.testapp.nick.canadajson.viewModel.CanadaFactsViewModel


class MainActivity : AppCompatActivity() {
    lateinit var swipeContainer: SwipeRefreshLayout
    lateinit var recyclerView: RecyclerView
    lateinit var canadaFactsViewModel: CanadaFactsViewModel
    lateinit var canadaRecyclerAdapter: CanadaRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.canadaList)
        swipeContainer = findViewById(R.id.swipeContainer)

        setRecyclerView()

        swipeContainer.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        )
        canadaFactsViewModel = ViewModelProviders.of(this).get(CanadaFactsViewModel::class.java)
        swipeContainer.setOnRefreshListener {
            // Your code to refresh the list here.
            // Make sure you call swipeContainer.setRefreshing(false)
            // once the network request has completed successfully.
            setUpBindings()
        }
    }

    fun setRecyclerView() {
        canadaRecyclerAdapter = CanadaRecyclerAdapter()
        recyclerView.adapter = canadaRecyclerAdapter
    }


    fun setUpBindings() {
        canadaFactsViewModel.getCanadaFactsDataFromAPI().observe(this, Observer<CanadaFactsRowsModel> {
            canadaRecyclerAdapter.setCanadaFactsList(it)
            recyclerView.setLayoutManager(LinearLayoutManager(this))
        })
    }

}
