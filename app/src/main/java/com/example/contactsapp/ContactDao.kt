package com.example.contactsapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addContacts(context: Contact)


    @Query("Select * from Contacts")
    fun getAllContacts() : LiveData<List<Contact>>

    @Delete
    fun delete(contact: Contact)
}