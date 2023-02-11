package com.example.contactsapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    val repository : ContactRepository
    init {
        val dao = ContactDatabase.getDatabaseInstance(application).contactDao()
        repository = ContactRepository(dao)
    }
    fun addContacts(contact: Contact){
        repository.insertContact(contact)
    }
    fun getAllContacts() : LiveData<List<Contact>> {
        return repository.getAllContacts()
    }
}