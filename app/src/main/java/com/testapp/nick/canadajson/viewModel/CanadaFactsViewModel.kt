package com.testapp.nick.canadajson.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.testapp.nick.canadajson.repository.CanadaFactsRepo

class CanadaFactsViewModel : ViewModel() {

    lateinit var repository: CanadaFactsRepo

    init {
        repository = CanadaFactsRepo()
    }

    fun getCanadaFactsDataFromAPI() : LiveData<List<CanadaFactsRowsModel>> {
       return repository.getMutableLiveData()
    }
}

