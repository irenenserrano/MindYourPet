package com.example.mindyourpet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindyourpet.database.Reminder

class ReminderAdapter : RecyclerView.Adapter<ReminderAdapter.ViewHolder>() {
    var data = listOf<Reminder>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reminder = data[position]
        holder.bind(reminder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.findViewById(R.id.reminder_title)

        fun bind(item: Reminder) {
            taskTitle.text = item.taskTitle
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflator  = LayoutInflater.from(parent.context)
                val view = layoutInflator.inflate(R.layout.reminder_item_view, parent, false)
                return ViewHolder(view)
            }
        }
    }
}