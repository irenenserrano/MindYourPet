package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RemindersListViewModel(list: List<Reminder>, application: Application) : ViewModel() {

   val database = list

   // this is the tonight varialbe in tracke my sleep
   var currentReminder = MutableLiveData<Reminder?>()
   // this is the nights variable in track my sleep, change once you have database available
   val listOfReminders = MutableLiveData(list)


}