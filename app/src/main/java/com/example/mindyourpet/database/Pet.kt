package com.example.mindyourpet.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pet_table")
data class Pet(
    @PrimaryKey(autoGenerate = true)
    var petId: Long = 0L,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "species_id")
    val speciesId: Int
)
