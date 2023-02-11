package com.example.contactsapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao

    companion object {
        @Volatile
        var INSTANCE : ContactDatabase?=null

        fun getDatabaseInstance(context : Context) : ContactDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val roomDatabaseInstance = Room.databaseBuilder(context,ContactDatabase::class.java,"Contacts").allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }

    }
}