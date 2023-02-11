package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.contactsapp.databinding.ActivityAddContactsBinding
import com.example.contactsapp.databinding.ContactLayoutBinding

class AddContacts : AppCompatActivity() {
    private lateinit var binding: ActivityAddContactsBinding
    val viewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.save.setOnClickListener{
            createContact()
        }
    }

    private fun createContact() {
        var name = binding.contactName.text.toString()
        var number = binding.contactNumber.text.toString()
        if (number.length > 10){
            Toast.makeText(this@AddContacts, "Enter a 10 digit number", Toast.LENGTH_SHORT).show()
        }
        else{
            val contact = Contact(null, name, number)
            viewModel.addContacts(contact)
            Toast.makeText(this@AddContacts, "Saved:)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@AddContacts,MainActivity::class.java)
            startActivity(intent)
        }

    }
}