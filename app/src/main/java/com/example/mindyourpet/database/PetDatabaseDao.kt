package com.example.mindyourpet.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


/**
 * Defines methods for using the Pet class with Room.
 */
@Dao
interface PetDatabaseDao {

    @Insert
    suspend fun addPet (pet: Pet)

    /**
     * Selects and returns the row that matches the petId which is our key.
     *
     * @param key petId
     */
    @Query("SELECT * from pet_table WHERE petId = :key")
    suspend fun getName(key: Long): Pet

    /**
     * Selects and returns all of the row that matches our species_id, which is our key.
     *
     * @param key speciesId
     *
     * This  method will return a List of Pets with that
     * Species Id meaning all cats and all dogs or all same species.
     */
    @Query("SELECT * from pet_table WHERE species_id = :key ORDER BY petId")
    fun getAllSpeciesId(key: Int): List<Pet>

    /**
     * Writes name and returns the row that matches the name, which is our key.
     *
     * @param key name of animal which is a string
     *
     * This method return a Pet.
     */
    @Query("SELECT * from pet_table WHERE name = :key")
    suspend fun getPetId(key: String): Pet

    /**
     * Selects and deletes form table that matched petId given.
     *
     * @param key
     */
    @Query("DELETE from pet_table WHERE petId = :key")
    suspend fun delete(key: Long)

}