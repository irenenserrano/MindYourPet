package com.example.mindyourpet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mindyourpet.database.Pet
import com.example.mindyourpet.database.PetDatabase
import com.example.mindyourpet.database.Reminder
import com.example.mindyourpet.database.ReminderDatabaseDao
import com.example.mindyourpet.databinding.RemindersListFragmentBinding

/**
 * Fragment listing all reminders and enabling a user to add a new reminder.
 * To add a new pet, the user clicks a Floating Action Button, which navigates to [AddReminderFragment].
 */
class RemindersListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get a reference to the binding object and inflate the fragment views.
        val binding: RemindersListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.reminders_list_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val args:RemindersListFragmentArgs = RemindersListFragmentArgs.fromBundle(requireArguments())
        val petId = args.petId
        val dataSource = PetDatabase.getInstance(application).ReminderDatabaseDao
        val adapter = ReminderAdapter()

        binding.reminderList.adapter = adapter

        val layoutManager = LinearLayoutManager(application)
        binding.reminderList.layoutManager = layoutManager

        val remindersListViewModel = ViewModelProvider(this, RemindersListViewModelFactory(dataSource, petId)).get(RemindersListViewModel::class.java)

        binding.remindersListViewModel = remindersListViewModel

        binding.lifecycleOwner = this

        adapter.data = remindersListViewModel.listOfReminders

        val fab: View = binding.root.findViewById(R.id.reminder_FAB)
        fab.setOnClickListener{
            val navController = findNavController()
            navController.navigate(
                RemindersListFragmentDirections.actionRemindersListFragmentToAddReminderFragment(petId))
        }
        return binding.root
    }
}