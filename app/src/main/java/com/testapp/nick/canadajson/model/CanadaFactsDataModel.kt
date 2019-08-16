package com.testapp.nick.canadajson.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "canadafactstable")
data class CanadaFactsDataModel (
    @PrimaryKey
    var id: String,
    var title: String?,
    var description: String?,
    var imageHref : String?
)