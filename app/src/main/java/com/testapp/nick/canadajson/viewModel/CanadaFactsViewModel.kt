package com.testapp.nick.canadajson.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.testapp.nick.canadajson.repository.CanadaFactsRepo

class CanadaFactsViewModel : ViewModel() {

    var repository: CanadaFactsRepo

    init {
        repository = CanadaFactsRepo()
    }

    fun getCanadaFactsDataFromAPI() : LiveData<CanadaFactsRowsModel> {
       return repository.getMutableLiveData()
    }
}

