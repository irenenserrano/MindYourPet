package com.example.mindyourpet

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter : RecyclerView.Adapter<TextItemViewHolder>(){
    var data = listOf<Pet>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val pet = data[position]

        holder.textView.text = pet.name.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.pet_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}