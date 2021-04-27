package com.example.mindyourpet.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


/**
 * Defines methods for using the Reminder class with Room.
 */
@Dao
interface ReminderDatabaseDao {

    @Insert
    suspend fun addTask(reminder: Reminder)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param  new value to write
     */
    @Update
    suspend fun update(task: Reminder)

    @Query("SELECT * from reminder_table WHERE taskId = :key")
    suspend fun getTask(key: Long)


    @Query("DELETE FROM reminder_table WHERE taskId = :key")
    suspend fun deleteTask(key: Long)



}
