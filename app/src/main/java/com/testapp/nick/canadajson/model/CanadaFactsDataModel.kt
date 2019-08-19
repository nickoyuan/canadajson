package com.testapp.nick.canadajson.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CanadaFactsDataModel (
    @SerializedName("title")
    @Expose
    var title: String?,

    @SerializedName("description")
    @Expose
    var description: String?,

    @SerializedName("imageHref")
    @Expose
    var imageHref : String?
)