package com.example.mindyourpet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter : RecyclerView.Adapter<PetAdapter.ViewHolder>() {
    var data = listOf<Pet>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pet = data[position]
        val res = holder.itemView.context.resources
        holder.name.text = pet.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.pet_item_view, parent, false)
        return ViewHolder(view)
    }
}
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.pet_name)
}