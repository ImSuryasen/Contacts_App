package com.example.contactsapp

import androidx.lifecycle.LiveData

class ContactRepository (val dao : ContactDao) {

    fun getAllContacts() : LiveData<List<Contact>> {
        return dao.getAllContacts()
    }
    fun insertContact(contact: Contact) {
        dao.addContacts(contact)
    }
}