package com.testapp.nick.canadajson.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "canada_facts_table")
data class CanadaFactsDataModel (

    @PrimaryKey
    var id : Int,

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