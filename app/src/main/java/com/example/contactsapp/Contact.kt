package com.example.contactsapp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Contacts")
class Contact (
        @PrimaryKey(autoGenerate = true)
        var id : Int? = null,
        var name: String,
        var number: String
        )