package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllPetsListViewModel(list: List<Pet>, application: Application) : ViewModel() {
    val database = list
    var currentPet = MutableLiveData<Pet?>()

    val listOfPets = MutableLiveData(list)

    val petString = currentPet.value?.name ?: "No pets found"
}