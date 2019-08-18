package com.testapp.nick.canadajson.retrofit

import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.testapp.nick.canadajson.utils.Urls
import retrofit2.Call
import retrofit2.http.GET
/**
"title":"About Canada",
"rows":[
{
"title":"Beavers",
"description":"Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
"imageHref":"http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
},
 ]
}
 */
interface ApiCallInterface {
    @GET(Urls.PATH)
    fun getFacts(): Call<List<CanadaFactsRowsModel>>
}