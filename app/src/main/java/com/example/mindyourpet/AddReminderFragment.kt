package com.example.mindyourpet

import android.R
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.navigation.databinding.AddReminderBinding


class AddReminderFragment : Fragment() {
    private var save_button: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

       val binding = DataBindingUtil.inflate<AddReminderBinding>(inflater,
            R.layout.add_reminder,container,false)

        //var titleTextBox = binding.title_input
        save_button = binding.saveButton

            binding.saveButton.setOnClickListener{ view: View ->

                var titleText = binding.title_input
                var titleValue = titleText.getText().toString()

                var notesText = binding.notes_box
                var notesValue = notesText.getText().toString()

                var mySpinner = binding.dropdown_menu
                var spinnerValue = mySpinner.getSelectedItem().toString()

                //figure out time picker
                //pass data to database
            }
        return binding.root
    }
}