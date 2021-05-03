package com.example.mindyourpet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindyourpet.database.Pet

class PetAdapter(var clickListener: OnPetItemClickListener) : RecyclerView.Adapter<PetAdapter.ViewHolder>() {
    var data = listOf<Pet>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pet = data[position]
        //holder.bind(pet)
        holder.init(pet, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.pet_name)

        fun init(item: Pet, action: OnPetItemClickListener) {
            name.text = item.name

            itemView.setOnClickListener{
                action.onPetItemClicked(item, adapterPosition)
            }
        }

//        fun bind(item: Pet) {
//            name.text = item.name
//        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflator = LayoutInflater.from(parent.context)
                val view = layoutInflator.inflate(R.layout.pet_item_view, parent, false)
                return ViewHolder(view)
            }
        }
    }
}

interface OnPetItemClickListener {
    fun onPetItemClicked(item: Pet, position: Int)
}