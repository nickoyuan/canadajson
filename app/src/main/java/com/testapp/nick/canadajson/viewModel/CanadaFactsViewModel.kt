package com.testapp.nick.canadajson.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.testapp.nick.canadajson.repository.CanadaFactsRepo

class CanadaFactsViewModel(application : Application) : AndroidViewModel(application) {

    var repository: CanadaFactsRepo

    init {
        repository = CanadaFactsRepo(application)
    }

    fun getCanadaFactsDataFromAPI() : LiveData<CanadaFactsRowsModel> {
       return repository.getMutableLiveData()
    }
}

