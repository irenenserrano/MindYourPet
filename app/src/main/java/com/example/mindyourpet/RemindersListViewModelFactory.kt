package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mindyourpet.database.Pet
import com.example.mindyourpet.database.ReminderDatabaseDao

class RemindersListViewModelFactory(private val dataSource: ReminderDatabaseDao, private val petId: Long) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RemindersListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RemindersListViewModel(dataSource, petId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
