package com.example.mindyourpet.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Defines methods for using the Reminder class with Room.
 */
@Dao
interface ReminderDatabaseDao {

    @Insert
    suspend fun addTask(reminder: Reminder)

    /**
     *This query is to get tasks with petId.
     *
     * @param Long petId
     *
     * This will return a list of reminders a client has for appropriate pet.
     */
    @Query(value = "SELECT * FROM reminder_table WHERE pet_id =:key ")
    suspend fun getTasksByPetID(key: Long): List<Reminder>

    /**
     *
     * Get the task with taskId
     *
     * @param Long because taskId is a long
     * and you are looking for its match.
     *
     * This will return tasks with matching taskId.
     */
    @Query("SELECT * from reminder_table WHERE taskId = :key")
    suspend fun getTask(key: Long): Reminder

    /**
     *
     * Get the petId By Task Title.
     *
     * @param String because task_title is a String
     * and you are looking to return the Reminder with the matching title.
     *
     * This will return a task with matching Title.
     */
    @Query("SELECT * from reminder_table WHERE task_title = :key")
    suspend fun getPetIdByTaskTitle(key: String): Reminder

    /**
     *
     * Get the petId By Task Title.
     *
     * @param Long will be used to delete a task with matching taskId.
     *
     */
    @Query("DELETE FROM reminder_table WHERE taskId = :key")
    suspend fun deleteTask(key: Long)

    /**
     *This query is to return count of tasks for all pets.
     *
     * @return Int
     */
    @Query("SELECT COUNT(*) FROM reminder_table")
    suspend fun getCountOfTasks(): Int
    //first error


    /**
     *This query is to clear all tasks for all pets
     *
     */
    @Query("DELETE FROM reminder_table")
    suspend fun clearAllTasks()

    /**
     *This query is to delete all completed tasks which for testign purposes will be
     * equal to 1 if completed and 0 if not completed.
     *
     * @param Int because task_completed is Int type.
     *
     * This will delete all those tasks that are equal to 1
     * which are completed tasks that should no longer be in list of to do's.
     */
    //1 == true //0==false
//    @Query( "DELETE FROM reminder_table WHERE task_completed == :key ")
//    suspend fun deleteAllCompletedTasks(key: Int)


    /**
     *This query is to delete a task that has the matching key/petId.
     *
     * @param key type long
     *
     * @return String
     */
//    @Query(value = "DELETE FROM reminder_table WHERE pet_id =:key ")
//    suspend fun deleteTasksByPetID(key: Long)


    /**
     *This query is to get count of tasks with same frequency so the three types in this case is Days, Weeks, Monthly.
     *If you are wondering how many tasks that are weekly? Or how many tasks that need to be done daily?
     * Or monthly?
     *
     * @return Int
     */
//    @Query(value = "SELECT COUNT(*) FROM reminder_table WHERE pet_id =:key GROUP BY task_frequency ")
//    suspend fun getCountOfTasksInDiffFrequency(key: Long): Int


    /**
     *This query is to get the last reminder for a specific task.
     * So lets say the client forgot if he gave food to specific pet 1
     * and he wanted to check.If he enters the @param key type Long
     * it will get that specific taskId matching key
     * and then get the last recorded time that was marked taskcompleted==1
     * which will be recorded and returned as a time that was last completed.
     *
     * @param key type long
     *
     * @return Long
     */
//    @Query(value = "SELECT * FROM reminder_table WHERE taskId =:key ORDER BY last_reminded ")
//    suspend fun getLastRemindedTimeForTask(key: Long): Long?


    /**
     *This query is to look for the latest reminder_time that has to be
     *  done in reference of time in clients present moment.
     *
     * @return Reminder
     */
//    @Query("SELECT * FROM reminder_table ORDER BY reminder_time DESC LIMIT 1")
//    suspend fun getLastReminder(): Reminder?

    /**
     *This query is to return a specific
     * description that has the matching taskId with key.
     *
     * @param key type long
     *
     * @return String
     */
//    @Query("SELECT * from reminder_table WHERE taskId = :key")
//    suspend fun getDescriptionWithTaskId(key: Long): String

    /**
     *This query is to return a Reminder.petId. with matching taskId.
     *
     * @param key type long
     *
     * @return Reminder
     */

    //how to do this right?
    //is the only way to test?
//    @Query("SELECT * from reminder_table WHERE taskId = :key")
//    suspend fun getPetIdWithTaskId(key: Long): Reminder


}
