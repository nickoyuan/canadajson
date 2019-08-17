package com.testapp.nick.canadajson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.testapp.nick.canadajson.databinding.ActivityMainBinding
import com.testapp.nick.canadajson.viewModel.CanadaFactsViewModel



class MainActivity : AppCompatActivity() {
    lateinit var swipeContainer: SwipeRefreshLayout
    lateinit var canadaFactsViewModel: CanadaFactsViewModel
    lateinit var activityMainBinder : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinder = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val recyclerView = activityMainBinder.canadaList
        val swipeContainer = activityMainBinder.swipeContainer

        swipeContainer.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        )

        swipeContainer.setOnRefreshListener {
            // Your code to refresh the list here.
            // Make sure you call swipeContainer.setRefreshing(false)
            // once the network request has completed successfully.
        }



        setUpBindings(savedInstanceState)
    }

    fun setUpBindings(savedInstanceState: Bundle?) {
       // canadaFactsViewModel = ViewModelProviders.of(this).get(CanadaFactsViewModel::class.java)

        setupListUpdate()
    }


    fun setupListUpdate() {
      /*  canadaFactsViewModel.getCanadaFactsDataFromAPI().observe(this, Observer<List<CanadaFactsDataModel>> {

        })*/


    }
}
