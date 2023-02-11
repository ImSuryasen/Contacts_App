package com.example.contactsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.databinding.ActivityMainBinding
import com.example.contactsapp.databinding.ContactLayoutBinding

class ContactAdapter(val context: Context, val list: List<Contact>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(val binding : ContactLayoutBinding) : RecyclerView.ViewHolder(binding.root){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ContactLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.contactName.text = list[position].name
        holder.binding.contactNumber.text = list[position].number
    }

    override fun getItemCount(): Int {
        return list.size
    }

}