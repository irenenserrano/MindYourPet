package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mindyourpet.database.Reminder
import com.example.mindyourpet.database.ReminderDatabaseDao
import kotlinx.coroutines.runBlocking

class RemindersListViewModel(dataSource:ReminderDatabaseDao, application: Application, petId: Long) : ViewModel() {

   val database = dataSource

   // this is the tonight varialbe in tracke my sleep
   var currentReminder = MutableLiveData<Reminder?>()
   // this is the nights variable in track my sleep, change once you have database available
   val listOfReminders = runBlocking { database.getTasksByPetID(petId) }

}