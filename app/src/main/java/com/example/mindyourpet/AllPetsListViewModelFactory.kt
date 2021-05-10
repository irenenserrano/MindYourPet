package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mindyourpet.database.Pet

class AllPetsListViewModelFactory(private val list: List<Pet>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllPetsListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AllPetsListViewModel(list) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}