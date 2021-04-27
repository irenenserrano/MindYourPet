package com.example.mindyourpet

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllPetsListViewModel(list: List<Pet>, application: Application) : ViewModel() {
    val database = list
    var currentPet = MutableLiveData<Pet?>()

    val listOfPets = MutableLiveData(list)

    val petString = currentPet.value?.name ?: "No pets found"

    private val _navigateToAddPet = MutableLiveData<Boolean>()
    val navigateToAddPet: LiveData<Boolean>
        get() = _navigateToAddPet

    fun onFabClicked() {
        _navigateToAddPet.value = true
    }

    fun onNavigatedToAddPet() {
        _navigateToAddPet.value = false
    }
}