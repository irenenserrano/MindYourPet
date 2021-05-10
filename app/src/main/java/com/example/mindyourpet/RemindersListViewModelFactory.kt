package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mindyourpet.database.Pet
import com.example.mindyourpet.database.ReminderDatabaseDao

class RemindersListViewModelFactory(private val dataSource: ReminderDatabaseDao, private val application: Application, private val petId: Long) : ViewModelProvider.Factory {
    /**
     * Creates a new instance of the given `Class`.
     *
     *
     *
     * @param modelClass a `Class` whose instance is requested
     * @param <T>        The type parameter for the ViewModel.
     * @return a newly created ViewModel
    </T> */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RemindersListViewModel::class.java)) {
            return RemindersListViewModel(dataSource, application, petId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
