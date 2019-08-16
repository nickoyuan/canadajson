package com.testapp.nick.canadajson.retrofit

import retrofit2.Retrofit

interface RetrofitCallInterface {
    fun getRetrofitClient() : Retrofit
    fun fetchCanadaFacts()
}