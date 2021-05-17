package com.example.mindyourpet.database

import android.view.inspector.InspectionCompanion
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pet_table")
data class Pet(

    @PrimaryKey(autoGenerate = true)
    var petId: Long = 0L,

    @ColumnInfo(name = "name")
    val name: String,

    /**
     * One of [CAT_ID], [DOG_ID], [BIRD_ID], [MONKEY_ID], or [FISH_ID].
     */
    @ColumnInfo(name = "species_id")
    val speciesId: Int
)
