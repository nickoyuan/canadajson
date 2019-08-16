package com.testapp.nick.canadajson.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.testapp.nick.canadajson.retrofit.NetworkClient

class CanadaFactsViewModel(application : Application) : AndroidViewModel(application) {

     lateinit var networkClient: NetworkClient

    fun getCanadaFactsDataFromAPI(date: String, latitude: Double, longitude: Double) {
        networkClient.fetchCanadaFacts()
    }

}

