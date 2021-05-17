package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mindyourpet.database.Reminder
import com.example.mindyourpet.database.ReminderDatabaseDao
import kotlinx.coroutines.runBlocking

class RemindersListViewModel(dataSource:ReminderDatabaseDao, petId: Long) : ViewModel() {
   val database = dataSource
   val listOfReminders = runBlocking { database.getTasksByPetID(petId) }
}