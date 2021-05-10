package com.example.mindyourpet

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.mindyourpet.database.Reminder
import com.example.mindyourpet.database.ReminderDatabaseDao
import kotlinx.coroutines.runBlocking

class AddReminderFragment : Fragment() {

    private lateinit var reminderDao: ReminderDatabaseDao

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //find view by id in fragment
        val view: View = inflater.inflate(R.layout.add_reminder, container, false)
        val saveBtn: Button = view.findViewById<Button>(R.id.save_button) as Button
        val cancelBtn: Button = view.findViewById<Button>(R.id.cancel_button)



        saveBtn.setOnClickListener {

            val titleText = view.findViewById<EditText>(R.id.title_input)
            var titleValue = titleText.text.toString()

            val notesText = view.findViewById<EditText>(R.id.notes_box)
            var notesValue = notesText.text.toString()

            val mySpinner = view.findViewById<Spinner>(R.id.dropdown_menu)
            var spinnerValue = mySpinner.getSelectedItem() as Int

            //time picker thing
            val timePicker = view.findViewById<TimePicker>(R.id.time_picker)
            val hour = timePicker.hour
            val min = timePicker.minute



            //create instance of database
            //val ob = DB(this.getActivity(),"database",null,1)

            //pass data to database
            //addTask(titleValue, notesValue, spinnerValue)

            val task = Reminder(
                    taskId=0,
                    petId=0,
                    taskTitle = titleValue,
                    taskFrequency= spinnerValue,
                    taskDescription = notesValue,
                    reminderTime= 0,
                    taskLastCompleted= 0,
                    taskLastReminded = 0  )


            runBlocking { reminderDao.addTask(task) }

        }

        cancelBtn.setOnClickListener {
            val titleText = view.findViewById<EditText>(R.id.title_input)
            titleText.text.clear()

            val notesText = view.findViewById<EditText>(R.id.notes_box)
            notesText.text.clear()

            val mySpinner = view.findViewById<Spinner>(R.id.dropdown_menu)
            mySpinner.setSelection(0)

            //figure out time picker
            val timePicker = view.findViewById<TimePicker>(R.id.time_picker)

        }
        return view
    }
}