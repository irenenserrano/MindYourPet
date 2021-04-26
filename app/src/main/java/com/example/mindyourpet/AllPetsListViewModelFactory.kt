package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AllPetsListViewModelFactory(private val list: List<Pet>,
private val application: Application) : ViewModelProvider.Factory {
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
        if (modelClass.isAssignableFrom(AllPetsListViewModel::class.java)) {
            return AllPetsListViewModel(list, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}