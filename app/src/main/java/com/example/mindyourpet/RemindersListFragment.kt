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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mindyourpet.databinding.RemindersListFragmentBinding

class RemindersListFragment : Fragment() {

    companion object {
        fun newInstance() = RemindersListFragment()
        val reminders = listOf<Reminder>(Reminder("Drugs"), Reminder("Get Food"))
    }

    private lateinit var viewModel: RemindersListViewModel
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get a reference to the binding object and inflate the fragment views.
        val binding: RemindersListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.reminders_list_fragment, container, false)

        val adapter = ReminderAdapter()
        binding.reminderList.adapter = adapter

        val application = requireNotNull(this.activity).application
        layoutManager = LinearLayoutManager(application)
        binding.reminderList.layoutManager = layoutManager

        val remindersListViewModel = ViewModelProvider(this, RemindersListViewModelFactory(reminders,application)).get(RemindersListViewModel::class.java)

        binding.remindersListViewModel = remindersListViewModel

        binding.lifecycleOwner = this

        remindersListViewModel.listOfReminders.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        val fab: View = binding.root.findViewById(R.id.reminder_FAB)
        fab.setOnClickListener{
            Toast.makeText(it.context, "Item Clicked", Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RemindersListViewModel::class.java)
    }

}