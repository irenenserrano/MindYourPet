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

class RemindersListFragment : Fragment() {

    companion object {
        fun newInstance() = RemindersListFragment()
    }

    private lateinit var viewModel: RemindersListViewModel
    lateinit var layoutManager: LinearLayoutManager
    private lateinit var dataSource: ReminderDatabaseDao
    private var petId: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get a reference to the binding object and inflate the fragment views.
        val binding: RemindersListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.reminders_list_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val args:RemindersListFragmentArgs = RemindersListFragmentArgs.fromBundle(requireArguments())
        petId = args.petId
        dataSource = PetDatabase.getInstance(application).ReminderDatabaseDao

        val adapter = ReminderAdapter()
        binding.reminderList.adapter = adapter

        layoutManager = LinearLayoutManager(application)
        binding.reminderList.layoutManager = layoutManager

        val remindersListViewModel = ViewModelProvider(this, RemindersListViewModelFactory(dataSource, application, petId)).get(RemindersListViewModel::class.java)

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RemindersListViewModel::class.java)
    }

}