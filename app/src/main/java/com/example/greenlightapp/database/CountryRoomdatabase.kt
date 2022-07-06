package com.example.greenlightapp.database

import android.content.ClipData
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ItemTable::class], version = 1)
abstract class CountryRoomdatabase(): RoomDatabase() {

    abstract fun getDao(): ItemDao

    companion object {
        private var INSTANCE: CountryRoomdatabase? = null

        fun getDatabaseObject(context: Context): CountryRoomdatabase {

            return if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, CountryRoomdatabase::class.java, "news_database")
                        .build()
                INSTANCE!!
            } else INSTANCE!!

        }
    }
}
