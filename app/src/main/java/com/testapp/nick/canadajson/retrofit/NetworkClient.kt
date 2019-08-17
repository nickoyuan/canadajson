package com.testapp.nick.canadajson.retrofit

import android.util.Log
import com.google.gson.Gson
import com.testapp.nick.canadajson.model.CanadaFactsDataModel
import com.testapp.nick.canadajson.utils.Urls
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class NetworkClient : RetrofitCallInterface {

    var retrofit: Retrofit? = null
    var TAG = "canadaApp"

    override fun getRetrofitClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(Urls.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!
    }

    /*override fun fetchCanadaFacts() {
        val gson = Gson()
        val retrofit = getRetrofitClient()
        val restApi = retrofit.create(ApiCallInterface::class.java)

        restApi.getFacts().enqueue(object : Callback<List<CanadaFactsDataModel>> {
            override fun onFailure(call: Call<List<CanadaFactsDataModel>>?, t: Throwable?) {
                Log.e(TAG, "OOPS!! something went wrong.. " + t!!.message)
            }

            override fun onResponse(call: Call<List<CanadaFactsDataModel>>?, response: Response<List<CanadaFactsDataModel>>?) {
                when (response!!.code()) {

                }
            }
        })
    }*/
}

