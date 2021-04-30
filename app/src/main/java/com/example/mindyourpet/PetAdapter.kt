package com.example.mindyourpet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        holder.bind(pet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: Button = itemView.findViewById(R.id.pet_name)

        fun bind(item: Pet) {
            name.text = item.name
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflator = LayoutInflater.from(parent.context)
                val view = layoutInflator.inflate(R.layout.pet_item_view, parent, false)
                return ViewHolder(view)
            }
        }
    }
}