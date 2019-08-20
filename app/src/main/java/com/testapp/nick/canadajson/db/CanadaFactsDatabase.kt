package com.testapp.nick.canadajson.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.testapp.nick.canadajson.model.CanadaFactsDataModel
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel

@Database(entities = [(CanadaFactsDataModel::class)], version = 1)
abstract class CanadaFactsDatabase : RoomDatabase(){

    abstract fun canadaFactsDao() : CanadaFactsDao

    companion object {
        @Volatile
        private var INSTANCE: CanadaFactsDatabase? = null

        fun getDatabase(
            context: Context
        ) : CanadaFactsDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CanadaFactsDatabase::class.java,
                    "canadaFactsDb.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}


