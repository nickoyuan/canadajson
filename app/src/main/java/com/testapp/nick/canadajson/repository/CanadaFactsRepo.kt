package com.testapp.nick.canadajson.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.testapp.nick.canadajson.retrofit.ApiCallInterface
import com.testapp.nick.canadajson.retrofit.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CanadaFactsRepo  {
    val TAG : String = "CanadaAPI"
    var liveData : MutableLiveData<List<CanadaFactsRowsModel>> = MutableLiveData()


     fun getMutableLiveData() : MutableLiveData<List<CanadaFactsRowsModel>> {

         var retrofitApiCall = NetworkClient().getRetrofitClient()

         val restApi = retrofitApiCall.create(ApiCallInterface::class.java)

         restApi.getFacts().enqueue(object : Callback<List<CanadaFactsRowsModel>> {
             override fun onFailure(call: Call<List<CanadaFactsRowsModel>>?, t: Throwable?) {
                 Log.e(TAG, "OOPS!! something went wrong.. " + t!!.message)
             }

             override fun onResponse(call: Call<List<CanadaFactsRowsModel>>?, response: Response<List<CanadaFactsRowsModel>>?) {

             }
         })
        return liveData
     }



}