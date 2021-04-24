package com.example.mindyourpet

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainActivityViewModel(dataSource: PetDatabaseDAO, application: Application) : ViewModel() {

    val database = dataSource

    private var pet = MutableLiveData<Pet?>()

    val pets = database.getAllPets()

    val petsString = Transformations.map(pets) { pets ->
        formatPets(pets, application.resources)
    }
//    fun onFABClicked() {
//
//    }
}