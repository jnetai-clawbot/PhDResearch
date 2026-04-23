package com.jnetai.phdresearch.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jnetai.phdresearch.model.*

@Database(entities = [Paper::class, Citation::class, Experiment::class], version = 1, exportSchema = false)
abstract class PhDResearchDatabase : RoomDatabase() {
    abstract fun dao(): PhDResearchDao
    companion object {
        @Volatile private var INSTANCE: PhDResearchDatabase? = null
        fun getInstance(context: Context): PhDResearchDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, PhDResearchDatabase::class.java, "phdresearch.db")
                .fallbackToDestructiveMigration().build().also { INSTANCE = it }
        }
    }
}