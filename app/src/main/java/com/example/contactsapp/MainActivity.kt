package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this@MainActivity,AddContacts::class.java)
            startActivity(intent)
        }
        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]
        viewModel.getAllContacts().observe(this, Observer { list->
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.recyclerView.adapter = ContactAdapter(this, list)
        })
    }
}