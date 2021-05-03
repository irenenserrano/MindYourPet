package com.example.mindyourpet

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Pet(
    @PrimaryKey(autoGenerate = true)
    var petId: Long = 0L,

    @ColumnInfo(name = "pet name")
    val name:String)

