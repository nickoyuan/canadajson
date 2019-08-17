package com.testapp.nick.canadajson.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.testapp.nick.canadajson.model.CanadaFactsDataModel
import com.testapp.nick.canadajson.retrofit.NetworkClient

class CanadaFactsViewModel(application : Application) : ViewModel() {

     lateinit var networkClient: NetworkClient

   /* fun getCanadaFactsDataFromAPI() : LiveData<List<CanadaFactsDataModel>> {
        return networkClient.fetchCanadaFacts()
    }*/



}

