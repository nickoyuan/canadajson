package com.testapp.nick.canadajson.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.testapp.nick.canadajson.retrofit.ApiCallInterface
import com.testapp.nick.canadajson.retrofit.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CanadaFactsRepo {
    val TAG: String = "CanadaAPI"
    var liveData: MutableLiveData<CanadaFactsRowsModel> = MutableLiveData()


    fun getMutableLiveData(): MutableLiveData<CanadaFactsRowsModel> {

        var retrofitApiCall = NetworkClient().getRetrofitClient()

        val restApi = retrofitApiCall.create(ApiCallInterface::class.java)

        restApi.getFacts().enqueue(object : Callback<CanadaFactsRowsModel> {
            override fun onFailure(call: Call<CanadaFactsRowsModel>?, t: Throwable?) {
                Log.e(TAG, "OOPS!! something went wrong.. " + t!!.message)
            }

            override fun onResponse(call: Call<CanadaFactsRowsModel>, response: Response<CanadaFactsRowsModel>) {
                liveData.value = response.body()!!
            }

        }
        )
        return liveData
    }


}