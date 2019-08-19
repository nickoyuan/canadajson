package com.testapp.nick.canadajson.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CanadaFactsRowsModel (
    @SerializedName("title")
    @Expose
    var title : String,

    @SerializedName("rows")
    @Expose
    var rows : MutableList<CanadaFactsDataModel>
)