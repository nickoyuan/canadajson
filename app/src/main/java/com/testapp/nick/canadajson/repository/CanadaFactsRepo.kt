package com.testapp.nick.canadajson.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import co.metalab.asyncawait.async
import com.testapp.nick.canadajson.db.CanadaFactsDatabase
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.testapp.nick.canadajson.retrofit.ApiCallInterface
import com.testapp.nick.canadajson.retrofit.NetworkClient
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CanadaFactsRepo(application: Application) {
    val TAG: String = "CanadaAPI"
    var liveData: MutableLiveData<CanadaFactsRowsModel> = MutableLiveData()
    var database: CanadaFactsDatabase

    init {
        database =  CanadaFactsDatabase.getDatabase(application)
    }

    fun updateCanadaList(canadaFacts: CanadaFactsRowsModel) {
        GlobalScope.launch {
            database.canadaFactsDao().insertAllCanadaFacts(canadaFacts.rows)
        }
    }

    fun fetchCanadaList() {
        async {
            liveData.value = await {
                CanadaFactsRowsModel("From Cache" , database.canadaFactsDao().getAllFactsFromDb()!!)
            }
            // Use result
        }
    }

    fun getMutableLiveData(): MutableLiveData<CanadaFactsRowsModel> {

        var retrofitApiCall = NetworkClient().getRetrofitClient()

        val restApi = retrofitApiCall.create(ApiCallInterface::class.java)

        restApi.getFacts().enqueue(object : Callback<CanadaFactsRowsModel> {
            override fun onFailure(call: Call<CanadaFactsRowsModel>?, t: Throwable?) {
                fetchCanadaList()
            }

            override fun onResponse(call: Call<CanadaFactsRowsModel>, response: Response<CanadaFactsRowsModel>) {
                liveData.value = response.body()!!
                updateCanadaList(response.body()!!)
            }

        }
        )
        return liveData
    }


}