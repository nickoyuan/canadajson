package com.testapp.nick.canadajson.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CanadaFactsRowsModel (

    @Expose
    @SerializedName("title") var title : String,

    @Expose
    @SerializedName("rows") var rows : MutableList<CanadaFactsDataModel>
)