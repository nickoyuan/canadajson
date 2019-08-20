package com.testapp.nick.canadajson.db

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.testapp.nick.canadajson.model.CanadaFactsDataModel
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel


@Dao
interface CanadaFactsDao {

    @Query("SELECT * FROM canada_facts_table")
    fun getAllFactsFromDb() : MutableList<CanadaFactsDataModel>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCanadaFacts(canadaFacts : MutableList<CanadaFactsDataModel>)

    @Query("DELETE FROM canada_facts_table")
    suspend fun deleteAllCanadaFacts()

}